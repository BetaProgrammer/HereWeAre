package yass.tawakadziruni.com.masterpiece;

import android.app.Activity;
import android.graphics.Color;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by T on 2017/12/09.
 */

public class ProfileAdapter_friends extends ArrayAdapter<profile>{

    public ProfileAdapter_friends(Activity context, ArrayList<profile> profiles ) {
        super(context, 0,profiles);
    }
    @NonNull
    @Override
    public View getView(int position, View convertView,  ViewGroup parent) {
        View listItemView = convertView;

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_invited, parent, false);

        }
        profile currentProfile=getItem(position);

        TextView FriendName=(TextView)listItemView.findViewById(R.id.FriendName);
        FriendName.setText(currentProfile.getProfileName());
        TextView FriendUsername=(TextView)listItemView.findViewById(R.id.FriendUserName);
        FriendUsername.setText("@"+currentProfile.getUserName());
        ImageView ProfileImage=(ImageView) listItemView.findViewById(R.id.imageView);
        try {
            ProfileImage.setImageResource(currentProfile.getProfileImage());

        }catch (Exception e){
            ProfileImage.setImageResource(R.drawable.ic_account_box_black_48dp);

        }



        if(currentProfile.getColor()!= R.color.strawberry) {
            listItemView.findViewById(R.id.inviteFriend).setBackgroundColor(currentProfile.getColor());
        }
        else{
            listItemView.findViewById(R.id.inviteFriend).setBackgroundColor(ContextCompat.getColor(getContext(),R.color.strawberry));
            listItemView.findViewById(R.id.inviteFriend).setBackgroundColor(ContextCompat.getColor(getContext(),R.color.tan));
        }



        return listItemView;



    }
}
