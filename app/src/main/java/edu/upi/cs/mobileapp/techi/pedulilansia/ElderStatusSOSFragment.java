package edu.upi.cs.mobileapp.techi.pedulilansia;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.upi.cs.mobileapp.techi.pedulilansia.databinding.FragmentElderStatusSosBinding;

public class ElderStatusSOSFragment extends Fragment implements View.OnClickListener
{
    /* private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2; */

    private FragmentElderStatusSosBinding binding;
    private FragmentTransaction transaction;

    private CountDownTimer countdown;

    public ElderStatusSOSFragment()
    {
        // Required empty public constructor
    }

    /* public static ElderStatusSosFragment newInstance(String param1, String param2)
    {
        ElderStatusSosFragment fragment = new ElderStatusSosFragment();
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
        binding = FragmentElderStatusSosBinding.inflate(inflater, container, false);

        // Inflate the layout for this fragment
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        binding.imgElderSosFallicon.setOnClickListener(this);
        binding.imgElderSosCircles.setOnClickListener(this);
        binding.txtElderSosStatusname.setOnClickListener(this);

        countdown = new CountDownTimer(10000, 1000)
        {
            public void onTick(long millisUntilFinished)
            {
                binding.txtElderSosCountdown.setText("Mengirim pesan otomatis\ndalam " +
                        (millisUntilFinished / 1000) + " detik...");
            }

            public void onFinish()
            {
                onClick(view);
            }
        }.start();

        binding.btnElderSosDecline.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                countdown.cancel();
                getActivity().finish();
            }
        });
    }

    @Override
    public void onClick(View view)
    {
        countdown.cancel();
        transaction = getActivity().getSupportFragmentManager().beginTransaction()
                .setReorderingAllowed(true);
        transaction.replace(R.id.elderalert, new ElderStatusDangerFragment()).commit();
    }
}