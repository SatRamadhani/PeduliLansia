package edu.upi.cs.mobileapp.techi.pedulilansia;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        // Set content view while hiding its action bar.
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
    }
}