package yass.tawakadziruni.com.masterpiece;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class launchSplashScreen extends Activity {
    // Firebase instance variables
    private FirebaseAuth mFirebaseAuth;
    private FirebaseUser mFirebaseUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FirebaseApp.initializeApp(getApplicationContext());


        FirebaseOptions firebaseOptions = new FirebaseOptions.Builder()
                .setDatabaseUrl("https://masterpiece-2ad40.firebaseio.com/")
                .setApiKey("AAAAGVtysAY:APA91bEDc7RYNRjPOK_UU2kiAtqZ_DmY9_nqP4JkWMjHOtOBCHy4UY8YnHp2bbhx_09By8D-zuO2k0_R3WIPibo3i2rmyiljqNYd7IuYoSISfLrrBIUiXX-xY-_s1U3R1bJY-UjuqzVi")
                .setApplicationId("Masterpiece").build();

        FirebaseApp myApp = FirebaseApp.initializeApp(getApplicationContext(),firebaseOptions,
                "Joll");


        // Initialize Firebase Auth
        mFirebaseAuth = FirebaseAuth.getInstance();
        mFirebaseUser = mFirebaseAuth.getCurrentUser();
        if (mFirebaseUser == null) {
            // Not signed in, launch the Sign In activity
            startActivity(new Intent(this, SignInFlow.class));
            finish();
            return;
        } else {
            Toast.makeText(getApplicationContext(),mFirebaseUser.getDisplayName(),Toast.LENGTH_SHORT).show();
            if (mFirebaseUser.getPhotoUrl() != null) {
              //  mPhotoUrl = mFirebaseUser.getPhotoUrl().toString();
            }
        }

        setContentView(R.layout.activity_launch_splash_screen);
        Window window = this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        Color fop;
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.StatusBar3));




    }
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        if (hasFocus) {


            ImageView YassLogo = findViewById(R.id.YassLogo);

            Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            YassLogo.startAnimation(animation);

            animation.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {

                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    Intent op = new Intent(launchSplashScreen.this, SignInFlow.class);
                    startActivity(op);

                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });

        }
    }}



