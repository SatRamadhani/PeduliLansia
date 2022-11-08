package edu.upi.cs.mobileapp.techi.pedulilansia;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

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

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == 1)
        {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
    }

    private void handleSignInResult(Task<GoogleSignInAccount> completedTask)
    {
        try
        {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);

            // Signed in successfully, show authenticated UI.
//            updateUI(account);
        }
        catch(ApiException e)
        {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            Log.w("failed", "signInResult:failed code=" + e.getStatusCode());
        }
    }
}