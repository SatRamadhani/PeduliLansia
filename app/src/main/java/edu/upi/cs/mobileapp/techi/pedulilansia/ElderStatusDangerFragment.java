package edu.upi.cs.mobileapp.techi.pedulilansia;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.upi.cs.mobileapp.techi.pedulilansia.databinding.FragmentElderStatusDangerBinding;

public class ElderStatusDangerFragment extends Fragment
{
    /* private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2; */

    private FragmentElderStatusDangerBinding binding;

    public ElderStatusDangerFragment()
    {
        // Required empty public constructor
    }

    /* public static ElderStatusDangerFragment newInstance(String param1, String param2)
    {
        ElderStatusDangerFragment fragment = new ElderStatusDangerFragment();
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
        binding = FragmentElderStatusDangerBinding.inflate(inflater, container, false);

        // Inflate the layout for this fragment
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
    }
}