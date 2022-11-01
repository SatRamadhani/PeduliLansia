package edu.upi.cs.mobileapp.techi.pedulilansia;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ncorti.slidetoact.SlideToActView;

import edu.upi.cs.mobileapp.techi.pedulilansia.databinding.FragmentElderStatusSafeBinding;

public class ElderStatusSafeFragment extends Fragment
{
    /* private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2; */

    private FragmentElderStatusSafeBinding binding;
    private FragmentTransaction transaction;
    private SharedPreferences preferences;

    public ElderStatusSafeFragment()
    {
        // Required empty public constructor
    }

    /* public static ElderStatusSafeFragment newInstance(String param1, String param2)
    {
        ElderStatusSafeFragment fragment = new ElderStatusSafeFragment();
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

        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("page", "elder_dashboard").commit();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        binding = FragmentElderStatusSafeBinding.inflate(inflater, container, false);

        // Inflate the layout for this fragment
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        binding.txtElderSafeName.setText(preferences.getString("gender", "") + " " + preferences.getString("name", " "));

        binding.elderBtnSafeMenu.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                transaction = getActivity().getSupportFragmentManager().beginTransaction()
                        .setReorderingAllowed(true).addToBackStack(null);
                transaction.add(R.id.main, new ElderMenuFragment()).commit();
            }
        });

        binding.elderSafeSlide.setOnSlideCompleteListener(new SlideToActView.OnSlideCompleteListener()
        {
            @Override
            public void onSlideComplete(@NonNull SlideToActView slideToActView)
            {
                startActivity(new Intent(getActivity(), ElderAlertActivity.class));
                new Handler().postDelayed(() ->
                {
                    binding.elderSafeSlide.setCompleted(false, false);
                }, 500);
            }
        });
    }
}