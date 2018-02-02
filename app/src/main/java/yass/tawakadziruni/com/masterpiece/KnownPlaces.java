package yass.tawakadziruni.com.masterpiece;

import android.os.Build;
import android.support.annotation.RequiresApi;

import java.util.Objects;

/**
 * Created by T on 2017/11/10.
 */

public class KnownPlaces {


    String TicketPro="TicketPro";
    String SandtonConventionCentre=" Sandton Convention Centre";

    String mPlaceTitle;
    double mLongitude;
    double mLatitude;
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public KnownPlaces(String Place){
        if(Objects.equals(Place, TicketPro) || Objects.equals(Place, "1")){
            mPlaceTitle=TicketPro;
            mLongitude=27.9410826;
            mLatitude=-26.0632093;

        }
        if(Place==SandtonConventionCentre|| Objects.equals(Place,"2")){
            mPlaceTitle=SandtonConventionCentre;
            mLatitude=-26.106068;
            mLongitude=28.0509993;
        }
    }

    public double getLatitude(){
        return mLatitude;
    }
    public  double getmLongitude(){
        return mLongitude;
    }


}
