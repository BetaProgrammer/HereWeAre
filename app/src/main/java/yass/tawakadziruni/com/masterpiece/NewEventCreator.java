package yass.tawakadziruni.com.masterpiece;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import junit.runner.Version;

import org.w3c.dom.Text;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.EventObject;
import java.util.List;

public class NewEventCreator extends AppCompatActivity implements Runnable, AdapterView.OnItemSelectedListener,datePick.OnFragmentInteractionListener{
private FirebaseDatabase mDatabase;
private DatabaseReference mEventDatabaseReference;
private ChildEventListener mChildEventListener;
public Date date=new Date();
public String fullDate;
private FirebaseAuth bb;
Bundle TheDate;


 static int getBitmap(int b){
     return b;
 }


    @Override
    public MenuInflater getMenuInflater() {
        return super.getMenuInflater();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
    Button dateMaker;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void run() {
          mDatabase=FirebaseDatabase.getInstance();

        mEventDatabaseReference=mDatabase.getReference().child("User Added events");

            MobileAds.initialize(getApplicationContext(), "ca-app-pub-7738678049484474~4268409190");


          /*  AdView adView = new AdView(this);
            adView.setAdSize(AdSize.BANNER);

            adView=findViewById(R.id.adView);
            AdRequest adRequest = new AdRequest.Builder().build();
            adView.loadAd(adRequest);
      */

        Window window=this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        Color fop;

        window.setStatusBarColor(ContextCompat.getColor(this,R.color.StatusBar2));


        final TextView EventName=(TextView) findViewById(R.id.textView3);
        final EditText eventNameInput=(EditText) findViewById(R.id.plain_text_input) ;
         final Button done=(Button) findViewById(R.id.done);


        final EditText venueText =(EditText) findViewById(R.id.venueText);
        final TextView eventName=(TextView) findViewById(R.id.textView) ;
        final TextView venue=(TextView) findViewById(R.id.textView2);


        eventNameInput.setFilters(new InputFilter[]{new InputFilter.LengthFilter(35)});
dateMaker=findViewById(R.id.datemaker);

        final Boolean[] a = {false};
        final Boolean[] b = {false};
            done.setEnabled(false);
        final TextWatcher pptx=new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }


            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                EventName.setText(eventNameInput.getText());
                int len;
                len=eventNameInput.length();


                TextView charLength=(TextView) findViewById(R.id.length);
                charLength.setText(Integer.toString(len));

                if(eventNameInput.length()==35){
                    Toast.makeText(getApplicationContext(),"The event name cannot be longer than "+charLength.getText().toString()+" words.",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                a[0] =true;
            }

        };

// TODO: 2017/12/10 write a bundle that can sendOver the date info from datePicker fragment

        eventNameInput.addTextChangedListener(pptx);

        final TextWatcher hoki=new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                done.setEnabled(false);

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                done.setEnabled(true);
                done.setVisibility(View.VISIBLE);
                if(venueText.getText().toString().matches("")){
                    done.setEnabled(false);

                }



            }


            @Override
            public void afterTextChanged(Editable s) {
                if(venueText.getText().toString().matches("") || eventNameInput.getText().toString().matches("")){
                    done.setEnabled(false);



                }
                if (eventNameInput.getText().toString().matches("")){
                    Toast.makeText(getApplicationContext(),"You need to give a name.",Toast.LENGTH_SHORT).show();
                }

            }

        };

        if (done.isEnabled()) {
            Toast.makeText(getApplicationContext(),"Button enabled",Toast.LENGTH_SHORT).show();
        }

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Event event=new Event(eventNameInput.getText().toString(),TheDate.getString("Date of Event"),venueText.getText().toString(),false);
                Toast.makeText(getApplicationContext(),TheDate.getString("Date of Event"),Toast.LENGTH_SHORT).show();
                mEventDatabaseReference.push().setValue(event);
                Toast.makeText(getApplicationContext(), "Sent", Toast.LENGTH_SHORT).show();
                NewEventCreator.this.finish();




            }
        });

        venueText.addTextChangedListener(hoki);


            // Creating adapter for spinner

            // Drop down layout style - list view with radio button

            // attaching data adapter to spinner
            final ArrayList<profile> InviteFriends =new ArrayList<profile>();



            ListView InviteFriendsListView=findViewById(R.id.inviteFriendsListView);
            InviteFriends.add(new profile("Tori Vega","ToriVeg253",getBitmap(R.drawable.tori)));
            InviteFriends.add(new profile("Tori Vega","ToriVeg253",getBitmap(R.drawable.tori)));
            InviteFriends.add(new profile("Beck","Beck Leck",getBitmap(R.drawable.tori)));
            InviteFriends.add(new profile("Tori Vega","ToriVeg253",getBitmap(R.drawable.tori)));
            InviteFriends.add(new profile("Tori Vega","ToriVeg253",getBitmap(R.drawable.tori)));
            InviteFriends.add(new profile("Tori Vega","ToriVeg253",getBitmap(R.drawable.tori)));
            InviteFriends.add(new profile("Tori Vega","ToriVeg253",getBitmap(R.drawable.tori)));
            InviteFriends.add(new profile("Tori Vega","ToriVeg253",getBitmap(R.drawable.tori)));
            InviteFriends.add(new profile("Tori Vega","ToriVeg253",getBitmap(R.drawable.tori)));
            InviteFriends.add(new profile("Tori Vega","ToriVeg253",getBitmap(R.drawable.tori)));
            InviteFriends.add(new profile("Robbie Shapiro","RobTheVent2734",getBitmap(R.drawable.download),ContextCompat.getColor(this,R.color.watermelon)));


            final ProfileAdapter_friends adapterFriends=new ProfileAdapter_friends(this,InviteFriends);
            InviteFriendsListView.setAdapter(adapterFriends);


            dateMaker.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        showDatePickerDialog();
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            });
    }

    public void showDatePickerDialog() throws ParseException {
        datePick newFragment = new datePick();
        newFragment.show(getSupportFragmentManager(), "datePicker");
        SimpleDateFormat ft=new SimpleDateFormat("yyyy-MM-dd");
        date=ft.parse(String.valueOf(newFragment.getDate()));
        fullDate= String.valueOf(date);


    }
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            Calendar newDate = Calendar.getInstance();
            newDate.set(year, monthOfYear, dayOfMonth);


        }




    @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {
Toast.makeText(getApplicationContext(),"You've got to set a date.",Toast.LENGTH_SHORT).show();

        }




// TODO: Add adView to your view hierarchy.


public void vle(View v){
     this.finish();
}
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String d;



        setContentView(R.layout.activity_new_event_creator);

     run();

        }


    @Override
    public void onRadioButtonChoice(Date choice) {
        SimpleDateFormat ft = new SimpleDateFormat("EEE, d MMM ");
       String pop=ft.format(choice);
       dateMaker.setText(pop);
        TheDate=new Bundle();
       TheDate.putString("Date of Event",pop);




    }

    }




