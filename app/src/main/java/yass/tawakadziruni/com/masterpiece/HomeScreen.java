package yass.tawakadziruni.com.masterpiece;

import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.design.widget.Snackbar;
import android.support.multidex.MultiDexApplication;
import android.support.v4.app.Fragment;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.lang.reflect.Array;
import java.util.ArrayList;



public class HomeScreen extends AppCompatActivity implements OnMapReadyCallback {
    //GoogleMap googleMap;
        SeekBar ZoomCustomControl;

        private FirebaseAuth mFireBaseAuth;
        private  FirebaseAuth.AuthStateListener mAuthStateListener;

        private boolean Pchoice=false;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        Toolbar action = findViewById(R.id.my_toolbar);
      setSupportActionBar(action);
        action.setTitle("Tandy");

ZoomCustomControl=findViewById(R.id.ZoomCustomControl);

        mFireBaseAuth=FirebaseAuth.getInstance();

        mAuthStateListener=new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    Snackbar snackbar = Snackbar.make(HomeScreen.this.getCurrentFocus(), "Signed in!", Snackbar.LENGTH_SHORT);
                    snackbar.show();
                } else {
                 //   startActivityForResult(());


                }
            }

            // Add the fragment to the 'fragment_container' FrameLayout

        };
        run();


    }

    @Override
    protected void onPause() {
        super.onPause();
        mFireBaseAuth.removeAuthStateListener(mAuthStateListener);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mFireBaseAuth.addAuthStateListener(mAuthStateListener);

    }




    LatLng LoacatdinHolder=new LatLng(26.0632093,26.0632093);
    ArrayList eventArrayHolder;


// TODO: 2017/12/30 Try getting the clicked on event info to be sent to the dialogFragment

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add_custom_event, menu);
        return true;

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.Add:
                Intent op = new Intent(HomeScreen.this, NewEventCreator.class);
                startActivity(op);
                return true;

            case R.id.LandingPage:
                Intent Profile = new Intent(HomeScreen.this, ProfilePage.class);
                startActivity(Profile);
                return true;
            default:
                return super.onOptionsItemSelected(item);


        }

    }


    public void onMapReady(final GoogleMap googleMap) {

            googleMap.addMarker(new MarkerOptions().position(LoacatdinHolder).title("Whatever"));
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(LoacatdinHolder));

            googleMap.setOnCameraMoveListener(new GoogleMap.OnCameraMoveListener() {
                @Override
                public void onCameraMove() {
                    float mapZoom=googleMap.getCameraPosition().zoom;
                    ZoomCustomControl.setProgress((int) mapZoom);
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        ZoomCustomControl.setMin((int)googleMap.getMinZoomLevel());
                    }
                    ZoomCustomControl.setMax((int) googleMap.getMaxZoomLevel());
                }
            });

            ZoomCustomControl.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    googleMap.moveCamera(CameraUpdateFactory.zoomTo((float)ZoomCustomControl.getProgress()));

                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {

                }
            });
            googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
            googleMap.setPadding(0,100,0,465);



    }








    public void sd() {

        Going.GoingFragment firstFragment = new Going.GoingFragment();


        android.support.v4.app.FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, firstFragment);
        transaction.addToBackStack(null);


        // Add the fragment to the 'fragment_container' FrameLayout
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, firstFragment).commit();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void run() {


        Window window = this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        Color fop;

        window.setStatusBarColor(ContextCompat.getColor(this, R.color.StatusBar));

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        int a=0;
        final ArrayList<Event> eventArray = new ArrayList<>();

        eventArray.add(new Event("John Legend", "2017-11-11", getDrawable(R.drawable.place_holder_john_legend),false));
        eventArray.add(new Event("Neil Diamond", "2017-12-09", getDrawable(R.drawable.download),false));
        eventArray.add(new Event("John Legend", "2017-11-11", getDrawable(R.drawable.place_holder_john_legend),false));
        eventArray.add(new Event("John Legend", "2017-11-11", getDrawable(R.drawable.place_holder_john_legend),false));
        eventArray.add(new Event("Maroon 5", "2017-05-06", getDrawable(R.drawable.place_holder_john_legend),false));
        eventArray.add(new Event("John Legend", "2017-11-11", getDrawable(R.drawable.place_holder_john_legend),false));
        eventArray.add(new Event("John Legend", "2017-11-11", getDrawable(R.drawable.place_holder_john_legend),false));
        eventArray.add(new Event("Madonna", "2017-10-10", getDrawable(R.drawable.tori),false));
        eventArray.add(new Event("John Legend", "2017-11-11", getDrawable(R.drawable.place_holder_john_legend),false));
        eventArray.add(new Event("John Legend", "2017-11-11", getDrawable(R.drawable.place_holder_john_legend),false));
        eventArray.add(new Event("John Legend", "2017-11-11", getDrawable(R.drawable.place_holder_john_legend),false));


        while(a<eventArray.size()){
            a+=1;

        }

        eventArrayHolder = eventArray;

        final EventAdapter adapter = new EventAdapter(this, eventArrayHolder);



        ProgressBar Initializing=(ProgressBar) findViewById(R.id.initLoad);
        final ListView eventList = findViewById(R.id.EventList);
        eventList.setAdapter(adapter);
        eventList.setOnLongClickListener(new android.widget.AdapterView.OnLongClickListener(){

            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(getApplicationContext(),"John Legend",Toast.LENGTH_SHORT).show();
                return true;
            }
        });
        eventList.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Event word3 = (Event) eventArrayHolder.get(position);

                Bundle arguments_Artists=new Bundle();
                Bundle arguments_Date=new Bundle();
                Bundle arguments_Venue=new Bundle();
                arguments_Artists.putString("Event Name",word3.getTitle());


                //arguments_Venue.putString("Venue",word3.getVenue());
                //arguments_Date.putString("Date",word3.getDateof());

                FragmentTransaction ft = getFragmentManager().beginTransaction();
                android.app.Fragment prev = getFragmentManager().findFragmentByTag("dialog");
                if (prev != null) {
                    ft.remove(prev);
                }
                ft.addToBackStack(null);

                // Create and show the dialog.

                getSupportFragmentManager().executePendingTransactions();


                Toast.makeText(getApplicationContext(),word3.getTitle(),Toast.LENGTH_SHORT).show();
                Going.GoingFragment dialogFragment=  Going.GoingFragment.newInstance(word3.getTitle(),word3.getVenue(),word3.getVenue());
                        //newInstance(word3.getTitle(),word3.getVenue(),word3.getDateof());
                dialogFragment.show(getSupportFragmentManager(),"Confirm.");

                Snackbar SnackClicked=Snackbar.make(view,"Loading event",Snackbar.LENGTH_SHORT);
                SnackClicked.show();

            }

        });


    }


  //  @Override
    public void onRadioButtonChoicew(Boolean choice) {
        Pchoice=choice;
        Toast.makeText(getApplicationContext(),"In This case the user going status is: "+Pchoice,Toast.LENGTH_SHORT ).show();

    }
}





