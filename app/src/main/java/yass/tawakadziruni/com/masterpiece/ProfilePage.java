package yass.tawakadziruni.com.masterpiece;


import android.annotation.SuppressLint;
import android.app.Activity;



import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Environment;

import android.support.annotation.RequiresApi;
import android.support.v13.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;


import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.facebook.rebound.BaseSpringSystem;
import com.facebook.rebound.SimpleSpringListener;
import com.facebook.rebound.Spring;
import com.facebook.rebound.SpringSystem;
import com.facebook.rebound.SpringUtil;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import java.net.MalformedURLException;

import java.net.ProtocolException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import static com.facebook.FacebookSdk.getApplicationContext;


public  class ProfilePage extends Activity {


    static HttpsURLConnection connection;
    static boolean loaded=false;
    private final BaseSpringSystem mSpringSystem = SpringSystem.create();
    private final ExampleSpringListener mSpringListener = new ExampleSpringListener();
    private FrameLayout mRootView;
    private Spring mScaleSpring;
    private View mImageView;



    class ExampleSpringListener extends SimpleSpringListener {
        @Override
        public void onSpringUpdate(Spring spring) {

            float mappedValue = (float) SpringUtil.mapValueFromRangeToRange(spring.getCurrentValue(), 0, 1, 1, 0.5);
            mImageView.setScaleX(mappedValue);
            mImageView.setScaleY(mappedValue);
        }
    }



    @SuppressLint("ClickableViewAccessibility")
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_profile_page);



        Context context = getApplicationContext();
        ConnectivityManager cm =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);


        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null && activeNetwork.isConnectedOrConnecting();


        if (!isConnected) {
            loaded = true;
            Toast NotConnected = Toast.makeText(getApplicationContext(), "There is no internet connection. Cannot show profile.", Toast.LENGTH_SHORT);
            NotConnected.show();
            this.finish();

        } else {
          /*
            (R.drawable.ic_official_developmental_logo));


*/
            ImageButton ProfilePic =  findViewById(R.id.profilePic);
            URL v = null;

            ProfilePic.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    switch (event.getAction()) {
                        case MotionEvent.ACTION_DOWN:
                            // When pressed start solving the spring to 1.
                            mScaleSpring.setEndValue(1);
                            break;
                        case MotionEvent.ACTION_UP:
                        case MotionEvent.ACTION_CANCEL:
                            // When released start solving the spring to 0.
                            mScaleSpring.setEndValue(0);
                            break;
                    }
                    return true;
                }
            });




            try {
               v=new URL("http://www.sftravel.com/sites/sftraveldev.prod.acquia-sites.com/files/SanFrancisco_0.jpg");
                Glide.with(this).load("http://www.sftravel.com/sites/sftraveldev.prod.acquia-sites.com/files/SanFrancisco_0.jpg").apply(RequestOptions.fitCenterTransform()).into(ProfilePic);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            Color fop;
            window.setStatusBarColor(ContextCompat.getColor(this, R.color.StatusBar3));


            final Button listLook = (Button) findViewById(R.id.List);
            Button homeLook = (Button) findViewById(R.id.Home);
            Button friendsLook = (Button) findViewById(R.id.friends);

            listLook.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listLook.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.StatusBar));
                    Toast.makeText(getApplicationContext(), "listLook clicked", Toast.LENGTH_SHORT).show();

                }


            });





    /* void updateUi(Bitmap bitmap) {
        ImageButton ProfilePic = (ImageButton) findViewById(R.id.profilePic);
        ProfilePic.setImageBitmap(getBitmap(bitmap));
        ProfilePic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent PhotoIntent = new Intent(Intent.ACTION_PICK);
                File photoDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
                Uri photoUri = Uri.parse(photoDirectory.getPath());
                PhotoIntent.setDataAndType(photoUri, "image/*");
                startActivity(PhotoIntent);
            }
        });
    }

    public Bitmap getBitmap(Bitmap b) {
        return b;
    }

    class Basync extends AsyncTask<String, Void, Bitmap> {
        HttpsURLConnection connection;



        @Override
        protected Bitmap doInBackground(String... strings) {
            URL pic = null;
            Bitmap ProfileImage = null;
            InputStream is = null;
            try {
                pic = new URL(strings[0]);
                connection = (HttpsURLConnection) pic.openConnection();
                connection.setRequestMethod("GET");
                connection.setReadTimeout(90000);
                connection.setConnectTimeout(19000);
                connection.connect();
                is = connection.getInputStream();


            } catch (ProtocolException e) {
                e.printStackTrace();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


            ProfileImage = BitmapFactory.decodeStream(is);


            return ProfileImage;


        }


        @Override
        protected void onPostExecute(Bitmap ProfileImage) {
            updateUi(ProfileImage);
            Context context=getApplicationContext();
*/

            cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            activeNetwork = cm.getActiveNetworkInfo();
            isConnected = activeNetwork != null && activeNetwork.isConnectedOrConnecting();
            if (!isConnected) {


            } else {
                Toast success = Toast.makeText(ProfilePage.this, "Successful load", Toast.LENGTH_SHORT);
                success.show();
            }

        }
    }
    }





















