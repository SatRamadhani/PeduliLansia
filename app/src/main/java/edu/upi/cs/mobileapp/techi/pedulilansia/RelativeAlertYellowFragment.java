package edu.upi.cs.mobileapp.techi.pedulilansia;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.upi.cs.mobileapp.techi.pedulilansia.databinding.FragmentRelativeAlertYellowBinding;

public class RelativeAlertYellowFragment extends Fragment
{
    /* private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2; */

    private AnimatedVectorDrawableCompat avdc;
    private AnimatedVectorDrawable avd;

    private FragmentRelativeAlertYellowBinding binding;

    public RelativeAlertYellowFragment()
    {
        // Required empty public constructor
    }


    /* public static RelativeAlertYellowFragment newInstance(String param1, String param2)
    {
        RelativeAlertYellowFragment fragment = new RelativeAlertYellowFragment();
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
        binding = FragmentRelativeAlertYellowBinding.inflate(inflater, container, false);

        // Inflate the layout for this fragment
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        Handler handler = new Handler();

        handler.postDelayed(() ->
        {
            Drawable drawable = binding.imgRelativeCheckmark.getDrawable();
            if(drawable instanceof AnimatedVectorDrawableCompat)
            {
                avdc = (AnimatedVectorDrawableCompat) drawable;
                avdc.start();
            }
            else
            {
                avd = (AnimatedVectorDrawable) drawable;
                avd.start();
            }
        }, 250);


        handler.postDelayed(() ->
        {
            startActivity(new Intent(getActivity(), RelativeMapsActivity.class));
            getActivity().finish();
        }, 2750);
    }
}