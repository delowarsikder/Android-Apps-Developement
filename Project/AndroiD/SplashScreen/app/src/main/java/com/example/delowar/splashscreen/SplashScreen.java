package com.example.delowar.splashscreen;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.telecom.Call;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;

public class SplashScreen extends Activity {

    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);
        progressBar=findViewById(R.id.progressId);


        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                doWork();
                CallActivity();
            }
        });
        thread.start();
    }


    public void doWork() {

        for (int i=10;i<=100;i+=5)
        {
            try {
                Thread.sleep(100);
                progressBar.setProgress(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void CallActivity() {
        Intent intent=new Intent(SplashScreen.this,MainActivity.class);
        startActivity(intent);
        finish();
    }


}
