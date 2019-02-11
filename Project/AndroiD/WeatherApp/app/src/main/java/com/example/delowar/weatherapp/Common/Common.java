package com.example.delowar.weatherapp.Common;

import android.support.annotation.NonNull;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Common {
    public static String API_KEY="ea187b6e4b51e7a53cf02227a259fe6a";
    public static String API_LINK="http://api.openweathermap.org/data/2.5/weather";//?lat={lat}&lon={lon} ";

    @NonNull
    public static String apiRequest(String lat, String lng)
    {
        StringBuilder stringBuilder=new StringBuilder(API_LINK);
        stringBuilder = stringBuilder.append(String.format("?lat=%s&lon=%s&appid=%s", lat, lng, API_KEY));
        return stringBuilder.toString();

        //http://api.openweathermap.org/data/2.5/weather?lat=35&lon=139&appid=ea187b6e4b51e7a53cf02227a259fe6a

        //String link=String.format("%s?lat=%s&lon=%s&appid=%s",API_LINK,lat,lng,API_KEY);
        //return link;
    }
    public static String unixTimeStandToDateTime(Double unixTime)
    {
        DateFormat dateFormat=new SimpleDateFormat("HH:mm");
        Date date=new Date();
        date.setTime((long) (unixTime*1000));
        return dateFormat.format(date);
    }
    public static String getImage(String icon)
    {
        return String.format("http://openweather.org/img/w/%s.png",icon);
    }
    public static String getDate()
    {
        DateFormat dateFormat=new SimpleDateFormat("dd MMMM yyyy HH mm");
        Date date= new Date();
        return dateFormat.toString();
    }

}
