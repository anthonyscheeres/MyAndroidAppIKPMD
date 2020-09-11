package com.example.myandriodikpmdapplication;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.myandriodikpmdapplication.interfaces.Archive;
import com.example.myandriodikpmdapplication.interfaces.BitmapI;
import com.example.myandriodikpmdapplication.interfaces.Http;
import com.example.myandriodikpmdapplication.interfaces.Identicon;
import com.example.myandriodikpmdapplication.interfaces.Token;
import com.example.myandriodikpmdapplication.models.Data;
import com.example.myandriodikpmdapplication.models.User;
import com.example.myandriodikpmdapplication.services.ArchiveOrgUrlService;
import com.example.myandriodikpmdapplication.services.BitmapService;
import com.example.myandriodikpmdapplication.services.HttpService;
import com.example.myandriodikpmdapplication.services.KweloIdenticon;
import com.example.myandriodikpmdapplication.services.UserIDService;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.NoSuchElementException;

public class MainActivity extends AppCompatActivity {

    //The app's name in local storage
    private final String NAME_OF_PREFERENCES = "Android_IKPMD8992";
    String userID = "userID";
    SharedPreferences settings;
    BitmapI imageBitmap = new BitmapService();
    // Database settings
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    //Initialize services
    Http http = new HttpService();
    Token identification = new UserIDService();
    Identicon pfp = new KweloIdenticon();
    GridView gridView;
    ImageView imageView;
    TextView textView;
    Archive archive = new ArchiveOrgUrlService();
    private AppBarConfiguration mAppBarConfiguration;

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
        // Read from the database

        //Get user data
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            // This method is called once with the initial value and again
            // whenever data at this location is updated.
            public void onDataChange(DataSnapshot dataSnapshot) {
                //Get data object from database and map to it's model
                User userData = dataSnapshot.getValue(User.class);

                Data.user = userData;

                //Bitmap decodedImage = imageBitmap.encode(userData.getProfilePicture());


                // update UI
                //imageView = (ImageView) findViewById(R.id.f);
                //textView = (TextView) findViewById(R.id.f2);
                //textView.setText(userData.getUserID());
                //imageView.setImageBitmap(decodedImage);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value

            }
        });

        // Initialize front end
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);


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