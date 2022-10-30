package edu.upi.cs.mobileapp.techi.pedulilansia;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class SignupActivity extends AppCompatActivity
{
    private FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        // Get information from WelcomeActivity.
        Bundle extras = getIntent().getExtras();
        int signup = (extras != null) ? extras.getInt("signup") : 0;

        // Set sign-up screen based on the information.
        transaction = getSupportFragmentManager().beginTransaction();
        if(signup == 1)
        {
            // Sign-up as Elder.
            transaction.add(R.id.signup, new GeneralWelcomeTopFragment())
                    .add(R.id.signup, new ElderSignupFragment());
        }
        else if(signup == 2)
        {
            // Sign-up as Relative.
            transaction.add(R.id.signup, new RelativeSignupFragment());
        }
        else
        {
            // Null case; activity will be forced to stop.
            finish();
        }

        transaction.commit();
        setContentView(R.layout.activity_signup);
    }
}