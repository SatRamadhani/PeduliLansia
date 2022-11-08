package edu.upi.cs.mobileapp.techi.pedulilansia;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.material.snackbar.Snackbar;

import edu.upi.cs.mobileapp.techi.pedulilansia.databinding.FragmentRelativeSignupBinding;

public class RelativeSignupFragment extends Fragment
{
    /* private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2; */

    private FragmentRelativeSignupBinding binding;
    private FragmentTransaction transaction;
    private SharedPreferences preferences;

    private GoogleSignInOptions gsio;
    private GoogleSignInClient gsic;

    public RelativeSignupFragment()
    {
        // Required empty public constructor.
    }

    /* public static RelativeSignupFragment newInstance(String param1, String param2)
    {
        RelativeSignupFragment fragment = new RelativeSignupFragment();
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

        gsio = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail().build();
        gsic = GoogleSignIn.getClient(getContext(), gsio);
    }

    @Override
    public void onStart()
    {
        super.onStart();

        GoogleSignInAccount gsia = GoogleSignIn.getLastSignedInAccount(getContext());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        binding = FragmentRelativeSignupBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        binding.relativeSignupGoogle.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = gsic.getSignInIntent();
                startActivityForResult(intent, 1);
            }
        });

        // Set onClickListener Relative Sign-Up Button.
        binding.relativeBtnSignup.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(binding.relativeInputSignupNama.getText().toString().isEmpty())
                {
                    Snackbar snackbar = Snackbar.make(getView(), "Mohon isi nama Anda!",
                            Snackbar.LENGTH_LONG);
                    snackbar.show();
                }
                else if(binding.relativeInputSignupEmail.getText().toString().isEmpty())
                {
                    Snackbar snackbar = Snackbar.make(getView(), "Mohon isi email Anda!",
                            Snackbar.LENGTH_LONG);
                    snackbar.show();
                }
                else if(binding.relativeInputSignupPassword.getText().toString().isEmpty())
                {
                    Snackbar snackbar = Snackbar.make(getView(), "Mohon isi password Anda!",
                            Snackbar.LENGTH_LONG);
                    snackbar.show();
                }
                else
                {
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("role", "relative")
                            .putString("status", "safe").commit();

                    startActivity(new Intent(getActivity(), MainActivity.class));
                    getActivity().finish();

                }

            }
        });

        binding.relativeTxtAltTextLogin.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                transaction = getActivity().getSupportFragmentManager().beginTransaction()
                        .setReorderingAllowed(true);
                transaction.replace(R.id.signup, new RelativeLoginFragment()).commit();
            }
        });
    }
}