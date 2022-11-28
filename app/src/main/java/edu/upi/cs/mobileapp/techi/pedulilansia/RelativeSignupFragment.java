package edu.upi.cs.mobileapp.techi.pedulilansia;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
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
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;
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
                String email = binding.relativeInputSignupEmail.getText().toString();
                String name = binding.relativeInputSignupNama.getText().toString();
                String pass = binding.relativeInputSignupPassword.getText().toString();

                if(name.isEmpty())
                {
                    Snackbar snackbar = Snackbar.make(getView(), "Mohon isi nama Anda!",
                            Snackbar.LENGTH_LONG);
                    snackbar.show();
                }
                else if(email.isEmpty())
                {
                    Snackbar snackbar = Snackbar.make(getView(), "Mohon isi email Anda!",
                            Snackbar.LENGTH_LONG);
                    snackbar.show();
                }
                else if(pass.isEmpty())
                {
                    Snackbar snackbar = Snackbar.make(getView(), "Mohon isi password Anda!",
                            Snackbar.LENGTH_LONG);
                    snackbar.show();
                }
                else
                {
//                    int status = requestSignUp(email, name, pass);
//                    if(status == 0)
//                    {
                        SharedPreferences.Editor editor = preferences.edit();
                        editor.putString("role", "relative")
                                .putString("status", "safe").commit();

                        startActivity(new Intent(getActivity(), MainActivity.class));
                        getActivity().finish();
//                    }
//                    else
//                    {
//                        Snackbar snackbar = Snackbar.make(getView(), "Email sudah terdaftar, " +
//                                        "login untuk melanjutkan!", Snackbar.LENGTH_LONG);
//                        snackbar.show();
//                    }
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

    private int requestSignUp(String email, String name, String password)
    {
        RequestParams params = new RequestParams();
        params.put("method", "signup");
        params.put("email", email);
        params.put("name", name);
        params.put("password", password);

        final int[] status = new int[1];
        status[0] = 1;

        GeneralDBElder.post("relative.php", params, new JsonHttpResponseHandler()
        {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response)
            {
                try
                {
                    status[0] = (int) response.get("status");
                    Log.d("status", "Status di try : " + status[0]);
                }
                catch(JSONException e)
                {
                    Log.e("json", "Failed : Not a JSON.");
                    e.printStackTrace();
                }
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response)
            {

            }
        });

        Log.i("status", "Status sebelum return : " + status[0]);
        return status[0];
    }
}