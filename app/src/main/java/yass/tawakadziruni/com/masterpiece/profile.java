package yass.tawakadziruni.com.masterpiece;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.annotation.ColorInt;
import android.support.v4.content.ContextCompat;

import java.util.ArrayList;

/**
 * Created by T on 2017/12/06.
 */
public class profile extends Object{
    String mprofileName;
    String mUserName;
    int mProfileImage;

    int mColor= (R.color.strawberry);

    ArrayList<ArrayList<Event>> mAttending=new ArrayList<ArrayList<Event>>();
    ArrayList<profile> mfriends=new ArrayList<>();



    public profile(String profileName,String Username) {
        mprofileName=profileName;
        mUserName=Username;

    }
    public profile(String profileName, String Username, int profileImage) {
        mprofileName=profileName;
        mUserName=Username;
        mProfileImage=profileImage;


    }

    public profile(String profileName, String Username, int profileImage, int color) {
        mprofileName=profileName;
        mUserName=Username;
        mProfileImage=profileImage;
        this.mColor=color;


    }
    ArrayList<profile> getFriends(){
        return mfriends;
    }
    ArrayList<ArrayList<Event>> getAttending(){
        return mAttending;
    }

    public void setAttening(ArrayList<Event> newEvent){
        mAttending.add(newEvent);
    }
        int getColor(){
        return mColor;
        }
        public void setColor(int profileColor){
            this.mColor=profileColor;
        }

    String getProfileName(){
        return mprofileName;
    }
    String getUserName(){
        return mUserName;
    }
    public int getProfileImage(){
        return mProfileImage;
    }

    public void setProfileName(String profileName) {
        this.mprofileName = profileName;
    }
}
