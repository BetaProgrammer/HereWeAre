package yass.tawakadziruni.com.masterpiece;

import android.graphics.drawable.Drawable;
import android.widget.Toast;

import com.google.android.gms.maps.model.LatLng;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import yass.tawakadziruni.com.masterpiece.KnownPlaces;

/**
 * Created by T on 2017/11/10.
 */

 class Event {
    private String mTitle;
    private String mDateOf;
    private Drawable mEventPhoto;
    KnownPlaces mKnownPlace;
    LatLng mNewMarker;
    private String mVenue;
    Boolean mIsAttending;

    private static final int NO_KNOWN_PLACE_PROVIDED = -1;



    public Event(String Title, String DateOf ,String venue,Boolean IsAttending) {
        mTitle = Title;
        mDateOf=DateOf;
        mVenue = venue;
        mIsAttending=IsAttending;

    }


    public String getDateof() {
        return mDateOf;
    }

    public String getTitle() {
        return mTitle;
    }

    public Date returnDate() {
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        Date t = new Date();
        try {
            t = ft.parse(mDateOf);

        } catch (ParseException e) {
            System.out.println("Oops.");
        }
        return t;
    }


    public Event(String Title, String dateOf, Drawable EventPhoto,Boolean IsAttending) {
        mTitle = Title;
        mDateOf = dateOf;
        mEventPhoto = EventPhoto;
        mIsAttending=IsAttending;

    }

    public Event(String Title, String dateOf, Drawable EventPhoto,Boolean IsAttending,KnownPlaces knownPlaces) {
        mTitle = Title;
        mDateOf = dateOf;
        mEventPhoto = EventPhoto;
        mKnownPlace=knownPlaces;



    }

    public Event(String Title, String dateOf, Drawable EventPhoto,Boolean IsAttending, LatLng newMarker) {
        mTitle = Title;
        mDateOf = dateOf;
        mEventPhoto = EventPhoto;
        mNewMarker=newMarker;




    }
public boolean IsKnownPlace(){
        Boolean state;
        if (mKnownPlace!=null){
            state=true;
        }
        else{
            state=false;
        }
        return state;


}
public boolean IsAttending() {
    Boolean state;
    if (mIsAttending != null || mIsAttending != false) {
        state = true;
    } else {
        state = false;

    }
    return state;
}


    public Drawable getEventPhoto() {
        return mEventPhoto;
    }


public String getVenue(){
    return mVenue;
}

}
