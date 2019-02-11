package com.example.delowar.androidlab;


import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends Activity {
    Button myButt;
    TextView myText;

    HttpURLConnection urlConnection;

    //a handler function
    StringBuilder result = new StringBuilder();

            try

    {
        URL url = null;
        try {
            url = new URL("https://api.github.com/users/dmnugent80/repos");
        } catch (MalformedURLException e1) {
            e1.printStackTrace();
        }
        HttpURLConnection urlConnection = null;
        try {
            urlConnection = (HttpURLConnection) url.openConnection();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        InputStream in = new BufferedInputStream(urlConnection.getInputStream());

        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        String line;
        while ((line = reader.readLine()) != null) {
            result.append(line);
        }

    }catch(
    Exception e)

    {
        e.printStackTrace();
    }
            finally

    {

        urlConnection.disconnect();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myButt = (Button) findViewById(R.id.buttonId);
        myText = (TextView) findViewById(R.id.textId);

        myButt.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {


                //For AsyncTask

                MyTask task = new MyTask();

                task.execute("10");

                //For AsyncTask

            }
        });
    }

    private class MyTask extends AsyncTask<String, String, String> {

        @Override
        protected void onPostExecute(String result) {
            // TODO Auto-generated method stub
            myText.setText(result);
        }

        @Override
        protected void onProgressUpdate(String... values) {
            // TODO Auto-generated method stub
            myButt.setText(values[0]);
        }

        @Override
        protected String doInBackground(String... params) {
            // TODO Auto-generated method stub
            int i;

            for (i = 0; i < Integer.parseInt(params[0]); i++) {
                try {
                    Thread.sleep(1000);
                    publishProgress("" + i);
                    //myText.setText(""+i);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
            return ("" + i);
        }
    }

}
