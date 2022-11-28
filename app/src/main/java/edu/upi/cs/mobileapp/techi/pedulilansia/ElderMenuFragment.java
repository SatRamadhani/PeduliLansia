package edu.upi.cs.mobileapp.techi.pedulilansia;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.upi.cs.mobileapp.techi.pedulilansia.databinding.FragmentElderMenuBinding;

public class ElderMenuFragment extends Fragment
{
    /* private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2; */

    private FragmentElderMenuBinding binding;
    private FragmentTransaction transaction;
    private SharedPreferences preferences;

    public ElderMenuFragment()
    {
        // Required empty public constructor
    }

    /* public static ElderMenuFragment newInstance(String param1, String param2)
    {
        ElderMenuFragment fragment = new ElderMenuFragment();
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
        binding = FragmentElderMenuBinding.inflate(inflater, container, false);

        // Inflate the layout for this fragment
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        setSelectedTabAttributes();

        binding.elderMenuJadwal.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                getActivity().getSupportFragmentManager().popBackStack();

                transaction = getActivity().getSupportFragmentManager().beginTransaction()
                        .setCustomAnimations(R.anim.slide_up, R.anim.fade_out, R.anim.fade_in,
                                R.anim.slide_down).setReorderingAllowed(true).addToBackStack(null);
                transaction.replace(R.id.main, new ElderScheduleFragment()).commit();
            }
        });

        binding.elderMenuMenuIcon.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                getActivity().getSupportFragmentManager().popBackStack();
            }
        });
    }

    private void setSelectedTabAttributes()
    {
        int color = ContextCompat.getColor(getContext(), R.color.primary_green);
        Drawable drawable = ContextCompat.getDrawable(getContext(), R.drawable.menu_selector);

        String page = preferences.getString("page", null);
        if(page.equals("elder_dashboard"))
        {
            binding.elderMenuDashboard.setTextColor(color);
            binding.elderMenuDashboard.setCompoundDrawablesWithIntrinsicBounds(drawable, null,
                    null, null);
        }
    }
}