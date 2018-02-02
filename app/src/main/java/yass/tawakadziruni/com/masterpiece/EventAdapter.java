package yass.tawakadziruni.com.masterpiece;

import android.app.Activity;
import android.location.Location;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Created by T on 2017/11/10.
 */

public class EventAdapter extends ArrayAdapter<Event> implements OnMapReadyCallback{

     EventAdapter(Activity context, ArrayList<Event> events) {
        super(context, 0, events);
    }


    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        Event currentEvent = getItem(position);

        TextView EventName = (TextView) listItemView.findViewById(R.id.EventName);
        assert currentEvent != null;

        EventName.setText(currentEvent.getTitle());



        TextView Date = listItemView.findViewById(R.id.DateOf);
        if(currentEvent.getVenue()!= null){
            Date.setText(currentEvent.getVenue());
        }
        else {
            String Dsate = String.valueOf(currentEvent.returnDate());
            Date.setText(Dsate);
        }

        if(currentEvent.mIsAttending==null){
            currentEvent.mIsAttending=false;
        }
        ImageView EventPhoto = (ImageView) listItemView.findViewById(R.id.EventPhoto);
        EventPhoto.setImageDrawable(currentEvent.getEventPhoto());
        TextView knownPlaceTag=(TextView) listItemView.findViewById(R.id.KnownPlace);
        CurrentEventHolder = currentEvent;
        return listItemView;
    }

    Event CurrentEventHolder;


    @Override
    public void onMapReady(GoogleMap googleMap) {
        if (CurrentEventHolder.IsKnownPlace()) {
            double Latitude = CurrentEventHolder.mKnownPlace.getLatitude();
            double Longitude = CurrentEventHolder.mKnownPlace.getmLongitude();
            LatLng Loacatdion = new LatLng(Latitude, Longitude);
            googleMap.addMarker(new MarkerOptions().position(Loacatdion).title(CurrentEventHolder.getTitle()));
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(Loacatdion));


        }
    }


}
