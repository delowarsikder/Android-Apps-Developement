package com.example.delowar.wheatherapp.Common;

import android.support.annotation.NonNull;

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
        stringBuilder = stringBuilder.append(String.format("?lat=%s&lng=%sAppid=%s&unit-matrix", lat, lng, API_KEY));
        return stringBuilder.toString();
    }
    public static String unitTimeStandToDateTime(Double unitTime)
    {
        DateFormat dateFormat=new SimpleDateFormat("HH:mm");
        Date date=new Date();
        date.setTime((long) (unitTime*1000));
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
