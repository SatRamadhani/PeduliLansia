package edu.upi.cs.mobileapp.techi.pedulilansia;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.upi.cs.mobileapp.techi.pedulilansia.databinding.FragmentRelativeMenuBinding;
import edu.upi.cs.mobileapp.techi.pedulilansia.databinding.FragmentRelativeSignupBinding;

public class RelativeMenuFragment extends Fragment
{

    /* private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2; */

    private FragmentRelativeMenuBinding binding;
    private FragmentTransaction transaction;
    private SharedPreferences preferences;

    public RelativeMenuFragment()
    {
        // Required empty public constructor
    }

    /* public static RelativeMenuFragment newInstance(String param1, String param2)
    {
        RelativeMenuFragment fragment = new RelativeMenuFragment();
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
        binding = FragmentRelativeMenuBinding.inflate(inflater, container, false);

        // Inflate the layout for this fragment
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        setSelectedTabAttributes();

        binding.relativeMenuReferensi.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                getActivity().getSupportFragmentManager().popBackStack();

                transaction = getActivity().getSupportFragmentManager().beginTransaction()
                        .setReorderingAllowed(true).addToBackStack(null);
                transaction.replace(R.id.main, new RelativePreferenceFragment()).commit();
            }
        });

        binding.relativeMenuBtnDebugDanger.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("status", "danger").commit();

                transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.main, new RelativeRedDashboardFragment()).commit();
                startActivity(new Intent(getActivity(), RelativeAlertActivity.class));
            }
        });

        binding.relativeMenuMenuIcon.setOnClickListener(new View.OnClickListener()
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
        int color;

        if(preferences.getString("status", "safe").equals("safe"))
        {
            color = ContextCompat.getColor(getContext(), R.color.primary_green);
        }
        else
        {
            color = ContextCompat.getColor(getContext(), R.color.red);
        }

        Drawable drawable = ContextCompat.getDrawable(getContext(), R.drawable.menu_selector);
        if(preferences.getString("page", null).equals("relative_dashboard"))
        {
            binding.relativeMenuDashboard.setTextColor(color);
            binding.relativeMenuDashboard.setCompoundDrawablesWithIntrinsicBounds(drawable, null,
                    null, null);
        }
        else if(preferences.getString("page", null).equals("relative_preference"))
        {
            binding.relativeMenuReferensi.setTextColor(color);
            binding.relativeMenuReferensi.setCompoundDrawablesWithIntrinsicBounds(drawable, null,
                    null, null);
        }
    }
}