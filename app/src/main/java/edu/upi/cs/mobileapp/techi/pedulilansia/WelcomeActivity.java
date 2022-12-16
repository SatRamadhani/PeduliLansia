package edu.upi.cs.mobileapp.techi.pedulilansia;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;
import edu.upi.cs.mobileapp.techi.pedulilansia.databinding.ActivityWelcomeBinding;

public class WelcomeActivity extends AppCompatActivity
{
    private ActivityWelcomeBinding binding;
    private FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= 21)
        {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(getResources().getColor(R.color.primary_green));
            window.setNavigationBarColor(getResources().getColor(R.color.primary_green));
        }

        // Add WelcomeTopFragment.
        // transaction = getSupportFragmentManager().beginTransaction();
        // transaction.add(R.id.welcome, new GeneralWelcomeTopFragment()).commit();

        // Set content view and binding.
        binding = ActivityWelcomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Set intent to pass data to SignUpActivity.
        Intent intent = new Intent(WelcomeActivity.this, SignupActivity.class);

        // Binding and data control.
        binding.welcomeBtnElder.setOnClickListener(view ->
        {
            intent.putExtra("signup", 1);
            debugClick();
            startActivity(intent);
        });

        binding.welcomeBtnRelative.setOnClickListener(view ->
        {
            intent.putExtra("signup", 2);
            debugClick();
            startActivity(intent);
        });
    }

    private void debugClick()
    {
        GeneralDBElder.get("test.php", null, new JsonHttpResponseHandler()
        {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response)
            {
                int status = 0;
                String message = "";

                try
                {
                    status = (int) response.get("success");
                    message = (String) response.get("message");
                }
                catch(JSONException e)
                {
                    Log.e("debug", "Not a JSON.");
                    e.printStackTrace();
                }

                Log.d("debug", message + " : " + status);
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response)
            {

            }
        });
    }
}