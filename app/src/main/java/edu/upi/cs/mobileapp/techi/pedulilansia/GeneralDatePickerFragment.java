package edu.upi.cs.mobileapp.techi.pedulilansia;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;

import com.google.android.material.snackbar.Snackbar;

import java.util.Calendar;

public class GeneralDatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener
{
    private Calendar calendar;

    @NonNull @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState)
    {
        calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int date = calendar.get(Calendar.DATE);

        return new DatePickerDialog(getActivity(),
                (DatePickerDialog.OnDateSetListener) getParentFragment(), year, month, date);
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth)
    {
        calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

        Snackbar snackbar = Snackbar.make(getView(), "Masuk kok!",
                Snackbar.LENGTH_LONG);
        snackbar.show();
        Log.i("ElderSignupFragment", "onDateSet: working");
    }
}