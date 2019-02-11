package com.example.delowar.kuethelpdesk;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;

//call at first at a one time in app !!!

public class WellComeScreen extends AppCompatActivity {

    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_well_come_screen);
        progressBar = findViewById(R.id.progressId);


        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                doWork();
                CallActivity();
            }
        });
        thread.start();
    }


    public void doWork() {

        for (int i = 10; i <= 100; i += 5) {
            try {
                Thread.sleep(100);
                progressBar.setProgress(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void CallActivity() {
        Intent intent = new Intent(WellComeScreen.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

}
