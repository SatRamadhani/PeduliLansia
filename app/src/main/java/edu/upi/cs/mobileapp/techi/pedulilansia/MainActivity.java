package edu.upi.cs.mobileapp.techi.pedulilansia;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import edu.upi.cs.mobileapp.techi.pedulilansia.databinding.FragmentWelcomeTopBinding;

public class MainActivity extends AppCompatActivity
{
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        preferences = getApplicationContext().getSharedPreferences("user", 0);

        if (Build.VERSION.SDK_INT >= 21)
        {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(getResources().getColor(R.color.primary_green));
            window.setNavigationBarColor(getResources().getColor(R.color.primary_green));
        }

        // Set content view.
        setContentView(R.layout.activity_main);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        int user = preferences.getInt("login", 0);
        System.out.println("In MainActivity : " + user);

        transaction.add(R.id.frameLayout, new WelcomeTopFragment());
        if(user == 1)
        {
            transaction.add(R.id.frameLayout, new ElderSignupFragment());
        }
        else if(user == 2)
        {
            transaction.add(R.id.frameLayout, new RelativeSignupFragment());
        }
        else
        {
            transaction.add(R.id.frameLayout, new RelativeRedAlertFragment());
        }

        transaction.commit();
    }
}