package edu.upi.cs.mobileapp.techi.pedulilansia;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Calendar;

public class GeneralDatePickerFragment extends DialogFragment
{
    @NonNull @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState)
    {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int date = calendar.get(Calendar.DATE);

        return new DatePickerDialog(getActivity(),
                (DatePickerDialog.OnDateSetListener) getParentFragment(), year, month, date);
    }
}