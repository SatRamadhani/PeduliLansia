package edu.upi.cs.mobileapp.techi.pedulilansia;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    private FragmentTransaction transaction;
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        preferences = getSharedPreferences("edu.upi.cs.mobileapp.techi.pedulilansia.user",
                MODE_PRIVATE);
        transaction = getSupportFragmentManager().beginTransaction();

        String user = preferences.getString("role", null);
        if(user.equals("elder"))
        {
            transaction.add(R.id.main, new ElderStatusSafeFragment());
        }
        else if(user.equals("relative"))
        {
            if(preferences.getString("status", "safe").equals("safe"))
            {
                transaction.add(R.id.main, new RelativeDashboardFragment());
            }
            else
            {
                transaction.add(R.id.main, new RelativeRedDashboardFragment());
            }
        }
        else
        {
            finish();
        }

        transaction.commit();
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onBackPressed()
    {
        if(getSupportFragmentManager().getBackStackEntryCount() >= 1)
        {
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("page", "relative_dashboard").commit();
        }

        super.onBackPressed();
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
    }
}