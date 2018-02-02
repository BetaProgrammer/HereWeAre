package yass.tawakadziruni.com.masterpiece;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import yass.tawakadziruni.com.masterpiece.R;
public class Going {
    public static class GoingFragment extends DialogFragment {
        String answer;
       static TextView textView;

        public static GoingFragment newInstance(String artistName, String venue,String date){


            GoingFragment fragment = new GoingFragment();
            Bundle arguments_Artists=new Bundle();
            Bundle arguments_Date=new Bundle();
            Bundle arguments_Venue=new Bundle();
            arguments_Artists.putString("Event Name",artistName);
           // arguments_Venue.putString("Venue",venue);
            //arguments_Date.putString("Date",date);


            fragment.setArguments(arguments_Artists);
           // fragment.setArguments(arguments_Date);
            //fragment.setArguments(arguments_Venue);

            return fragment;
        }


        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
             View myFragmentView = inflater.inflate(R.layout.list_item, container, false);

            TextView textView=myFragmentView.findViewById(R.id.EventName);
            textView.setText(getArguments().getString("Event Name"));//getArguments().getString("Event Name"));
            Toast.makeText(getContext(),"#"+ getArguments().getString("Event Name"),Toast.LENGTH_SHORT).show();






            return myFragmentView;

        }


        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);




        }

        @NonNull
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {


            TextView textView=getActivity().findViewById(R.id.EventName);
            textView.setText(getArguments().getString("Event Name"));
            return new AlertDialog.Builder(getActivity())

                    .setView(R.layout.list_item)
                    .setPositiveButton("Yes",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int whichButton) {
                                    Toast YouAreGoing = Toast.makeText(getContext(), "You're going. Updated your public profile", Toast.LENGTH_LONG);
                                    YouAreGoing.show();
                                    answer = "true";
                                }
                            }
                    )
                    .setNegativeButton("no", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int whichButton) {
                                    GoingFragment.this.getDialog().cancel();
                                    Toast Cancelled = Toast.makeText(getContext(), "Not going", Toast.LENGTH_SHORT);
                                    Cancelled.show();
                                    answer = "false";
                                }
                            }
                    )
                    .create();
        }


    }
}
