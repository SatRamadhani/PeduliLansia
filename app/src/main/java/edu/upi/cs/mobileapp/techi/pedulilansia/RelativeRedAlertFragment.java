package edu.upi.cs.mobileapp.techi.pedulilansia;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.upi.cs.mobileapp.techi.pedulilansia.databinding.FragmentRelativeRedAlertBinding;

public class RelativeRedAlertFragment extends Fragment
{
    /* private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2; */

    private FragmentRelativeRedAlertBinding binding;

    public RelativeRedAlertFragment()
    {
        // Required empty public constructor
    }

    /* public static RelativeRedAlertFragment newInstance(String param1, String param2)
    {
        RelativeRedAlertFragment fragment = new RelativeRedAlertFragment();
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
        binding = FragmentRelativeRedAlertBinding.inflate(inflater, container, false);

        // Inflate the layout for this fragment
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        new CountDownTimer(60000, 1000)
        {
            public void onTick(long millisUntilFinished)
            {
                binding.relativeTxtAlertCountdown.setText("Mengabaikan peringatan dalam " +
                        (millisUntilFinished / 1000) + " detik...");
            }

            public void onFinish()
            {

            }
        }.start();
    }
}