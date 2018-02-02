package yass.tawakadziruni.com.masterpiece;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.DialogFragment;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

public class datePick extends DialogFragment implements DatePickerDialog.OnDateSetListener {


    datePick.OnFragmentInteractionListener mListener2;

    Date mdate;
    static DatePickerDialog fd;

    interface OnFragmentInteractionListener {
        void onRadioButtonChoice(Date choice);

    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof datePick.OnFragmentInteractionListener) {
            mListener2 = (datePick.OnFragmentInteractionListener) context;
        } else {
            throw new ClassCastException(context.toString()
                    + "Both know ");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Calendar go = Calendar.getInstance() ;
        go.setTime(mdate);
        mListener2.onRadioButtonChoice(go.getTime());



    }



    @Override
    public Dialog onCreateDialog (Bundle savedInstanceState) {


        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        fd=new DatePickerDialog(getActivity(), this, year, month, day);

        return fd;
    }



    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        mdate=new Date(fd.getDatePicker().getYear(),fd.getDatePicker().getMonth(),fd.getDatePicker().getDayOfMonth());



    }
    public Date getDate(){
        return mdate;
    }
}






