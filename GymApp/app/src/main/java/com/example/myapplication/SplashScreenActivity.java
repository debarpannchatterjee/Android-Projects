package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        //TRANSPARENT STATUS BAR
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        //HIDE ACTION BAR
        getSupportActionBar().hide();

        Thread thread= new Thread(){
            public void run() {
                try {

                    sleep(4000);

                } catch (Exception e) {

                    e.printStackTrace();
                } finally {

                    Intent intent = new Intent(SplashScreenActivity.this, MainActivity.class);
                    startActivity(intent);

                }
            }
        }; thread.start();
    }
}