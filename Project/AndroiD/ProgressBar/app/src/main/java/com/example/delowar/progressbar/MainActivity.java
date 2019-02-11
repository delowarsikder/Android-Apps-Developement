package com.example.delowar.progressbar;

import android.app.Activity;
import android.os.Bundle;
import android.view.DragAndDropPermissions;
import android.view.DragEvent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.ThemedSpinnerAdapter;

public class MainActivity extends Activity {


    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        progressBar=findViewById(R.id.progressId);

        //remove action title
       // requestWindowFeature(Window.FEATURE_NO_TITLE);

        //remove notification bar
       // getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);


        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    doWork();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }
    public void doWork() throws InterruptedException {
        for(int i=10;i<=100;i+=10)
        {
            Thread.sleep(1000);
            progressBar.setProgress(i);
        }
    }
}
