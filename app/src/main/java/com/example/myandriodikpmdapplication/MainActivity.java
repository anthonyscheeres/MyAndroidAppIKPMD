package com.example.myandriodikpmdapplication;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.myandriodikpmdapplication.interfaces.BitmapI;
import com.example.myandriodikpmdapplication.interfaces.Http;
import com.example.myandriodikpmdapplication.interfaces.Identicon;
import com.example.myandriodikpmdapplication.interfaces.Token;
import com.example.myandriodikpmdapplication.models.DataHolder;
import com.example.myandriodikpmdapplication.models.User;
import com.example.myandriodikpmdapplication.services.BitmapService;
import com.example.myandriodikpmdapplication.services.HttpService;
import com.example.myandriodikpmdapplication.services.KweloIdenticon;
import com.example.myandriodikpmdapplication.services.UserIDService;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class MainActivity extends AppCompatActivity {

    //The app's name in local storage
    final String NAME_OF_PREFERENCES = "Android_IKPMD8992";
    // Database settings
    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    final Token identification = new UserIDService();
    final Identicon pfp = new KweloIdenticon();
    String userID = "userID";
    SharedPreferences settings;
    BitmapI imageBitmap = new BitmapService();
    //Initialize services
    Http http = new HttpService();
    AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Enable usage of local storage by creating this object at startup
        settings = getSharedPreferences(NAME_OF_PREFERENCES, MODE_PRIVATE);

        try {
            userID = identification.get(settings);
        } catch (NoSuchElementException err) {
            userID = database.getReference().push().getKey();
            new Thread(() -> {
                identification.update(settings, userID, http, database, pfp);
            }).start();
        }
        //Initialize the object that allows modifying the user his account data
        DatabaseReference myRef = database.getReference(userID);

        // Initialize front end
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);

        View hView = navigationView.inflateHeaderView(R.layout.nav_header_main);


        //Get user data
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            // This method is called once with the initial value and again
            // whenever data at this location is updated.
            public void onDataChange(DataSnapshot dataSnapshot) {
                //Get data object from database and map to it's model
                final User userData = dataSnapshot.getValue(User.class);

                DataHolder.user = userData;


                final Bitmap decodedImage = imageBitmap.encode(userData.getProfilePicture());

                final ImageView imageView = hView.findViewById(R.id.f);
                final TextView textView = hView.findViewById(R.id.f2);
                textView.setText(userData.getUserID());
                imageView.setImageBitmap(decodedImage);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value

            }
        });


        //makeTheBarChart();


        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
        Snackbar.make(navigationView, "Welcome ", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();


    }



    public void makeTheBarChart() {
        BarChart chart = (BarChart) findViewById(R.id.barchart);
        List<BarEntry> entries = new ArrayList<>();

        entries.add(new BarEntry(0f, 30f));
        entries.add(new BarEntry(1f, 80f));
        entries.add(new BarEntry(2f, 60f));
        entries.add(new BarEntry(3f, 50f));   // gap of 2f
        entries.add(new BarEntry(5f, 70f));
        entries.add(new BarEntry(6f, 60f));
        BarDataSet set = new BarDataSet(entries, "BarDataSet");
        BarData data = new BarData(set);
        chart.setData(data);
        chart.setDescription(new Description( ));
        chart.animateXY(2000, 2000);
        chart.invalidate();
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    protected void onPause() {
        super.onPause();


    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}