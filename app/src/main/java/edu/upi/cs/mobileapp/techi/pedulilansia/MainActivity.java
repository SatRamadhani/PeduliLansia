package edu.upi.cs.mobileapp.techi.pedulilansia;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.SharedPreferences;
import android.os.Bundle;

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
            transaction.add(R.id.main, new ElderStatusDangerFragment());
        }
        else if(user.equals("relative"))
        {
            transaction.add(R.id.main, new RelativeDashboardFragment());
        }
        else
        {
            finish();
        }

        transaction.commit();
        setContentView(R.layout.activity_main);
    }
}