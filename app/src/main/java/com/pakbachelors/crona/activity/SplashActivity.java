package com.pakbachelors.crona.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.pakbachelors.crona.MainActivity;
import com.pakbachelors.crona.R;
import com.pakbachelors.crona.app.Session;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {

    private Session session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        session = new Session(this);
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                if (!session.isFirstTimeLaunch()) {
                    //launchHomeScreen();
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    finish();
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                } else {
                    startActivity(new Intent(getApplicationContext(), IntroActivity.class));
                    finish();
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                }
            }
        }, 2000);
    }
}
