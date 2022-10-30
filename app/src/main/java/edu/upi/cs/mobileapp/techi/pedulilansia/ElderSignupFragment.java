package edu.upi.cs.mobileapp.techi.pedulilansia;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputEditText;

import org.w3c.dom.Text;

import java.util.Calendar;

import edu.upi.cs.mobileapp.techi.pedulilansia.databinding.FragmentElderSignupBinding;

public class ElderSignupFragment extends Fragment
{
    /* private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2; */

    private FragmentElderSignupBinding binding;
    private SharedPreferences preferences;

    private Calendar calendar;
    private TextInputEditText text;

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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        binding = FragmentElderSignupBinding.inflate(inflater, container, false);
        preferences = getActivity().getSharedPreferences(
                "edu.upi.cs.mobileapp.techi.pedulilansia.user", Context.MODE_PRIVATE);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        // Set onClickListener Date Picker.
        DialogFragment dialog = new GeneralDatePickerFragment();
        // EditText text = (EditText) getView().findViewById(R.id.elder_input_signup_birthdate);
        binding.elderInputSignupBirthdate.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                dialog.show(getActivity().getSupportFragmentManager(), "Tanggal");
            }
        });

        // Set onClickListener Elder Sign-Up Button.
        // Button signup = (Button) getView().findViewById(R.id.elder_btn_signup);
        binding.elderBtnSignup.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("role", "elder").commit();

                startActivity(new Intent(getActivity(), MainActivity.class));
                getActivity().finish();
            }
        });
    }
}