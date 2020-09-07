package com.example.myandriodikpmdapplication;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myandriodikpmdapplication.interfaces.Http;
import com.example.myandriodikpmdapplication.interfaces.Identicon;
import com.example.myandriodikpmdapplication.interfaces.Token;
import com.example.myandriodikpmdapplication.models.User;
import com.example.myandriodikpmdapplication.services.HttpService;
import com.example.myandriodikpmdapplication.services.KweloIdenticon;
import com.example.myandriodikpmdapplication.services.UserIDService;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.io.IOException;
import java.util.NoSuchElementException;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private final String NAME_OF_PREFERENCES = "Android_IKPMD8992";

    String userID = "userID";
    SharedPreferences settings;
    ImageView imageView;
    TextView textView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        //Enable usage of local storage by creating this object at startup
        settings = getSharedPreferences(NAME_OF_PREFERENCES, MODE_PRIVATE);

        // Database settings
        FirebaseDatabase database = FirebaseDatabase.getInstance();

       //Initialize services
        Http http = new HttpService();
        Token identification = new UserIDService();




        try{

            userID = identification.get(settings);

        }catch (NoSuchElementException err){
            userID = database.getReference().push().getKey();

            Identicon pfp = new KweloIdenticon();


            new Thread(() -> {


                identification.update(settings, userID, http, database, pfp);


            }).start();

        }

        //Initialize the object that allows modifying the user his account data
        DatabaseReference myRef = database.getReference(userID);

        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                User userData = dataSnapshot.getValue(User.class);



                imageView = findViewById(R.id.imageView);


                textView = findViewById(R.id.textView);

                textView.setText(userData.getUserID());



                byte[] byteArrayOfAnImage = Base64.decode(userData.getProfilePicture().replace("data:image/png;base64",""), Base64.DEFAULT);
                Bitmap decodedImage = BitmapFactory.decodeByteArray(byteArrayOfAnImage, 0, byteArrayOfAnImage.length);


                imageView.setImageBitmap(decodedImage);

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
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
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
}