package edu.upi.cs.mobileapp.techi.pedulilansia;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.messaging.FirebaseMessaging;

public class SplashScreenActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        // Initialize Firebase Messaging.
        /* FirebaseApp.initializeApp(getApplicationContext());
        FirebaseMessaging.getInstance().getToken()
                .addOnCompleteListener(new OnCompleteListener<String>()
                {
                    @Override
                    public void onComplete(@NonNull Task<String> task)
                    {
                        if(!task.isSuccessful())
                        {
                            Log.e("firebase", "Fetching FCM token failed.");
                            return;
                        }

                        // Get new FCM token.
                        String token = task.getResult();

                        // Token : dxX5LDJ7S8ipY4GXirgj9c:APA91bGd9zKcQWFYUr0VRgPW5sdekrVqNKj53KP1msRkS2IIlzQw01qgm9LShhEzoilYSSdZeARD4PdFUw6nh5bxQgTJPehfcEyylvyS-ddQJeeZFkc-G8rmQu9IyLZuwsq7pV_vzZcp
                        Log.d("firebase", token);
                    }
                }); */

        // Hide the bottom navigation bar.
        View view = getWindow().getDecorView();
        view.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE |
                View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION |
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
                View.SYSTEM_UI_FLAG_FULLSCREEN |
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        // Set content view.
        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(() ->
        {
            // Start MainActivity.
            startActivity(new Intent(SplashScreenActivity.this, WelcomeActivity.class));
            finish();
        }, 3000);
    }
}