package edu.upi.cs.mobileapp.techi.pedulilansia;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.upi.cs.mobileapp.techi.pedulilansia.databinding.FragmentRelativePreferenceBinding;

public class RelativePreferenceFragment extends Fragment
{
    /* private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2; */

    private FragmentRelativePreferenceBinding binding;
    private FragmentTransaction transaction;
    private SharedPreferences preferences;

    public RelativePreferenceFragment()
    {
        // Required empty public constructor
    }

    /* public static RelativePreferenceFragment newInstance(String param1, String param2)
    {
        RelativePreferenceFragment fragment = new RelativePreferenceFragment();
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
        editor.putString("page", "relative_preference").commit();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        binding = FragmentRelativePreferenceBinding.inflate(inflater, container, false);

        // Inflate the layout for this fragment
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        binding.relativePreferenceMenuIcon.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                transaction = getActivity().getSupportFragmentManager().beginTransaction()
                        .setReorderingAllowed(true).addToBackStack(null);
                transaction.add(R.id.main, new RelativeMenuFragment()).commit();
            }
        });
    }
}