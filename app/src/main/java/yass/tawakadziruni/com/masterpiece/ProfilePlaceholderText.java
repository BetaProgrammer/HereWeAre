package yass.tawakadziruni.com.masterpiece;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class ProfilePlaceholderText extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "Lorem ipsum dskjnfdkjssnkjdknjvkdjfdv fdb vfdjnjdfkv  dfbjnkvfdjvfndfvkdvfnnfdvkjdfvnjjdfvjnkdfvjnkdfnjdfvjjnkdfvndfvjnkdfvjnkdfvnjkfdvnkjfdvnjfdv" +
            "fdvjnkdfvnkjjndfjndfvnkdfvjnjdfkjkdfvnkjnkvfdkkfdvjnkjknkdfvnkfvdnkndfjnfnjfnkjnfdnjkjnkfdjkndfvjnfdnjkkjdfjnkfvdkjnnjkdfnkfnkjvfkjjnfdv" +
            "fdvkkfnjjdfjnvfjdnknvkdfnkfdvnkkjndfvnjfdnkjndfvnjkfdvjnjnkdfnjjndfknjkvnjnjkfvdjknjnfvdjnknkjnkdfnjnkdfv";
    private static final String ARG_PARAM2 = "vdfkmfdvkllfkfdvkfdv fdvmkdfvmkfdklkfdkmvkmllkvdfmfvmldfklfkmdfvmkdfkldldfvkmdfvmkmdfvl ";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public ProfilePlaceholderText() {
    }


    public static ProfilePlaceholderText newInstance(String param1, String param2) {
        ProfilePlaceholderText fragment = new ProfilePlaceholderText();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        TextView placeholderBullshit=(TextView) container.findViewById(R.id.PlaceHolder);
        placeholderBullshit.setText(ARG_PARAM1+ARG_PARAM2);

        return inflater.inflate(R.layout.fragment_profile_placeholder_text, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }



    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}
