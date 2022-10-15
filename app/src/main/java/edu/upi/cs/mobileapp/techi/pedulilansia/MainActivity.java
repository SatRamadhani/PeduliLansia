package edu.upi.cs.mobileapp.techi.pedulilansia;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.ActionBar;
import android.os.Bundle;

import edu.upi.cs.mobileapp.techi.pedulilansia.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        // Set content view while hiding its action bar.
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frameLayout, new WelcomeFragment());
        transaction.commit();
    }
}