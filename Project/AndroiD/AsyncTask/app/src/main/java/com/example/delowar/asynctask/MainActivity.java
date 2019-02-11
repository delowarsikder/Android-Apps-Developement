package com.example.delowar.asynctask;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
    public static String data = "";
    //    StringBuilder result = new StringBuilder();
    String API_old = "https://api.androidhive.info/contacts/";
    String API_LINK = "https://api.myjson.com/bins/opi96";


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
                task.execute(API_LINK);
                //For AsyncTask
            }
        });
    }

    private class MyTask extends AsyncTask<String, Void, String> {
        String data = "";
        String singleParse="";
        String dataParse="";

        @Override
        protected String doInBackground(String... strings) {

            try {
                URL url = new URL(strings[0]);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String line = "";
                while (line != null) {
                    line = bufferedReader.readLine();
                    data = data + line;
                }
                // Getting JSON Array node
                JSONArray contacts = new JSONArray(data);

                // looping through All Contacts
                for (int i = 0; i < contacts.length(); i++) {
                    JSONObject c = (JSONObject) contacts.get(i);

                    String id = c.getString("id");
                    String name = c.getString("name");
                    String email = c.getString("email");
                    String address = c.getString("address");
                    String gender = c.getString("gender");

                    // Phone node is JSON Object
                    JSONObject phone = c.getJSONObject("phone");
                    String mobile = phone.getString("mobile");
                    String home = phone.getString("home");
                    String office = phone.getString("office");
                    singleParse="id :"+id+"\n"+"Name :"+name+"\n"+"Email :"+email+"\n"+"Address :"+address+
                            "\n"+"Gender :"+gender+"\n"+"Mobile :"+mobile+"\n"+"Home :"+home+"\n"+"Office :"+ office+"\n";
                    dataParse=dataParse+singleParse+"\n";
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            myText.setText(dataParse);
            super.onPostExecute(s);
        }
    }

}