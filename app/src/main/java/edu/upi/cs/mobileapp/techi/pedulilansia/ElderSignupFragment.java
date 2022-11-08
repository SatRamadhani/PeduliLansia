package edu.upi.cs.mobileapp.techi.pedulilansia;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;

import com.google.android.material.snackbar.Snackbar;

import org.w3c.dom.Text;

import java.text.DateFormat;
import java.util.Calendar;

import edu.upi.cs.mobileapp.techi.pedulilansia.databinding.FragmentElderSignupBinding;

public class ElderSignupFragment extends Fragment implements DatePickerDialog.OnDateSetListener
{
    /* private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2; */

    private FragmentElderSignupBinding binding;
    private SharedPreferences preferences;

    private Calendar calendar;
    private DialogFragment dialog = new GeneralDatePickerFragment();

    public ElderSignupFragment()
    {
        // Required empty public constructor.
    }

    /* public static ElderSignupFragment newInstance(String param1, String param2)
    {
        ElderSignupFragment fragment = new ElderSignupFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);

        return fragment;
    } */

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        preferences = getActivity().getSharedPreferences(
                "edu.upi.cs.mobileapp.techi.pedulilansia.user", Context.MODE_PRIVATE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        binding = FragmentElderSignupBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        // Set onClickListener Date Picker.
        binding.elderInputSignupBirthdate.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                dialog.show(getActivity().getSupportFragmentManager(), "Tanggal");
            }
        });

        // Set onClickListener Elder Sign-Up Button.
        binding.elderBtnSignup.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(binding.elderInputSignupNama.getText().toString().isEmpty())
                {
                    Snackbar snackbar = Snackbar.make(getView(), "Mohon isi nama Anda!",
                            Snackbar.LENGTH_LONG);
                    snackbar.show();
                }
                else if(binding.elderInputSignupRadiogroup.getCheckedRadioButtonId() == (-1))
                {
                    Snackbar snackbar = Snackbar.make(getView(), "Mohon isi jenis kelamin Anda!",
                            Snackbar.LENGTH_LONG);
                    snackbar.show();
                }
                else
                {
                    String name = binding.elderInputSignupNama.getText().toString();
                    int gender = binding.elderInputSignupRadiogroup.getCheckedRadioButtonId();

                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("role", "elder").putString("name", name);

                    if(gender == binding.maleRadio.getId())
                    {
                        editor.putString("gender", "Pak");
                    }
                    else
                    {
                        editor.putString("gender", "Bu");
                    }

                    editor.commit();
                    startActivity(new Intent(getActivity(), MainActivity.class));
                    getActivity().finish();
                }
            }
        });
    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth)
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