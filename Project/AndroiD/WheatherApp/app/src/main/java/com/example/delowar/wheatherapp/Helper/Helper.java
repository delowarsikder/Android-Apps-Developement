package com.example.delowar.wheatherapp.Helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class Helper {

    public Helper() {
    }

    public static String stream=null;

    public static String getHttpData(String urlString)
    {
        try {
            URL url=new URL(urlString);
            HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
            if(httpURLConnection.getResponseCode()==200) ///ok 200
            {
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                StringBuilder stringBuilder=new StringBuilder();
                String line;
                while ((line=bufferedReader.readLine() )==null)
                {
                    stringBuilder.append(line);
                    stream=line.toString();
                    httpURLConnection.disconnect();
                }
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stream;
    }
}
