package com.example.delowar.kuethelpdesk;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ShowActivity extends AppCompatActivity {

    TextView textView;
    String API_LINK1 = "http://api.myjson.com/bins/mn3bi";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        textView = findViewById(R.id.showtv_Id);
        new MyTask().execute(API_LINK1);
    }

    private class MyTask extends AsyncTask<String, String, String> {


        @Override
        protected void onPostExecute(String result) {

            JSONArray array = null;

            try {
                array = new JSONArray(result);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            StringBuilder stringBuilder = new StringBuilder();
            // looping through All Contacts
            for (int i = 0; i < array.length(); i++) {

                String Serial, CourseCode, Title, Credit, PreRequisite, temp;

                JSONObject C = null;
                C = array.optJSONObject(i);
                Serial = C.optString("sl");
                CourseCode = C.optString("course code\t");
                Title = C.optString("title\t");
                Credit = C.optString("credit\t");
                PreRequisite = C.optString("pre-requisite");

                temp = "Serial : " + Serial + "\n" + "Course Code : " + CourseCode + "\n" + "Title : " + Title + "\n" + "Credit : " + Credit + "\n" + "PreRequisite : " + PreRequisite + "\n\n\n\n";
                stringBuilder.append(temp);

                /**
                 CourseCode = C.optString("course code\\t");
                 Title = C.optString("title\\t");
                 Credit = C.optString("credit\\t");
                 PreRequisite = C.optString("PreRequisite");
                 **/
            }

            String string = stringBuilder.toString();

            textView.setText(string);

        }


        @Override
        protected String doInBackground(String... params) {

            //Toast.makeText(MainActivity.this, "Dhon !!!", Toast.LENGTH_SHORT).show();

            StringBuilder result = new StringBuilder();
            HttpURLConnection urlConnection = null;
            try {
                URL url = new URL(params[0]);
                urlConnection = (HttpURLConnection) url.openConnection();
                InputStream in = new BufferedInputStream(urlConnection.getInputStream());

                BufferedReader reader = new BufferedReader(new InputStreamReader(in));

                String line;
                while ((line = reader.readLine()) != null) {
                    result.append(line);
                }

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                urlConnection.disconnect();
            }

            //text.setText(result.toString());

            return result.toString();


        }
    }

}
