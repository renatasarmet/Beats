package com.example.android.beats.SplashScreen_Scene;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.os.Handler;

import com.example.android.beats.Login_Scene.LoginActivity;
import com.example.android.beats.R;

public class SplashScreenActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                // Actions to do after 2 seconds
                Intent abreLogin = new Intent(SplashScreenActivity.this, LoginActivity.class);
                startActivity(abreLogin);
                finish();
            }
        }, 2000);
    }
}
