package com.example.delowar.jsonlabtest;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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

import static android.net.wifi.WifiConfiguration.Status.strings;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button button;
    String API_LINK = "https://www.json-generator.com/api/json/get/cfmPrrpkmW?indent=2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        listener();
    }

    private void listener() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyTask myTask = new MyTask();
                myTask.execute(API_LINK);
            }
        });
    }

    private void init() {
        button = findViewById(R.id.clickId);
        textView = findViewById(R.id.textId);
    }

    public class MyTask extends AsyncTask<String, String, String> {

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            String result = "";
            JSONArray jsonArray = null;
            try {
                jsonArray = new JSONArray(s);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            for (int i = 0; i < jsonArray.length(); i++) {
                String name = "";
                JSONObject jsonObject = null;
                try {
                    jsonObject = jsonArray.getJSONObject(i);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                JSONArray company = null;
                try {
                    company = jsonObject.getJSONArray("company");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                //  for(int j=0;j<company.length();j++){

                JSONObject companyJSONObject = null;
                try {
                    companyJSONObject = company.getJSONObject(2);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                try {
                    name = company.getString(0);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                JSONObject localAdd = null;
                try {
                    localAdd = companyJSONObject.getJSONObject("LocalAddress");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                JSONArray address = null;
                try {
                    address = localAdd.getJSONArray("Address");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                String data = "";
                for (int j = 0; j < address.length(); j++) {
                    String add = address.optString(j);
                    data = data + "\n" + add;
                    data=data+"\n";
                }
                result =result + "\n" + name + "\n" + data;
            }
            textView.setText(result);
        }

        @Override
        protected String doInBackground(String... strings) {

            StringBuilder result = new StringBuilder();
            HttpURLConnection httpURLConnection;
            try {
                URL url = new URL(strings[0]);
                httpURLConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = new BufferedInputStream(httpURLConnection.getInputStream());
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                String line;
                while ((line = reader.readLine()) != null) {
                    result.append(line);
                }

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return result.toString();
        }

    }
}