package edu.upi.cs.mobileapp.techi.pedulilansia;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity
{
    private SharedPreferences save;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        save = getApplicationContext().getSharedPreferences("user", 0);

        // Set content view.
        setContentView(R.layout.activity_main);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        int user = save.getInt("login", 0);
        System.out.println("In MainActivity : " + user);
        if(user == 1)
        {
            transaction.replace(R.id.frameLayout, new RelativeSignupFragment());
        }
        else if(user == 2)
        {
            transaction.replace(R.id.frameLayout, new ElderSignupFragment());
        }
        else
        {
            transaction.replace(R.id.frameLayout, new WelcomeFragment());
        }

        transaction.commit();
    }
}