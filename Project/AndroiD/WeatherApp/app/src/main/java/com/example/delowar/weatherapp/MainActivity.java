package com.example.delowar.weatherapp;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.delowar.weatherapp.Common.Common;
import com.example.delowar.weatherapp.Helper.Helper;
import com.example.delowar.weatherapp.Model.OpenWeatherMap;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.squareup.picasso.Picasso;
import java.lang.reflect.Type;

import static com.example.delowar.weatherapp.Common.Common.apiRequest;

public class MainActivity extends AppCompatActivity implements LocationListener {

    TextView textCity, textLastUpdate, textDescriptor, textHumidity, textTime, textCelsius;
    ImageView imageIcon;
    LocationManager locationManager;
    String provider;
    static double lat, lng;
    int MY_PERMISSION = 0;
    OpenWeatherMap openWeatherMap = new OpenWeatherMap();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //find in java file different view
        init();
        locationManager = (LocationManager) getApplicationContext().getSystemService(Context.LOCATION_SERVICE);
        provider = locationManager.getBestProvider(new Criteria(), false);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(MainActivity.this, new String[]{
                    Manifest.permission.INTERNET,
                    Manifest.permission.ACCESS_COARSE_LOCATION,
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_NETWORK_STATE,
                    Manifest.permission.SYSTEM_ALERT_WINDOW,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE

            }, MY_PERMISSION);
        }
        Location location = locationManager.getLastKnownLocation(provider);

        if (location == null) {
            Log.e("TAG", "No Location");
        }
    }

    public void init() {
        textCity = findViewById(com.example.delowar.weatherapp.R.id.cityId);
        textLastUpdate = findViewById(com.example.delowar.weatherapp.R.id.lastUpdateID);
        textDescriptor = findViewById(com.example.delowar.weatherapp.R.id.descriptorID);
        textHumidity = findViewById(com.example.delowar.weatherapp.R.id.humidityID);
        textTime = findViewById(com.example.delowar.weatherapp.R.id.timeID);
        textCelsius = findViewById(com.example.delowar.weatherapp.R.id.celsiusID);
        imageIcon = findViewById(com.example.delowar.weatherapp.R.id.imageId);
    }


    @Override
    protected void onPause() {
        Toast.makeText(getApplicationContext(), "on Pause", Toast.LENGTH_SHORT).show();
        super.onPause();
        locationManager.removeUpdates(this);
    }


    @Override
    protected void onResume() {
        Toast.makeText(getApplicationContext(), "on Resume ", Toast.LENGTH_SHORT).show();
        super.onResume();
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(MainActivity.this, new String[]{
                    Manifest.permission.INTERNET,
                    Manifest.permission.ACCESS_COARSE_LOCATION,
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_NETWORK_STATE,
                    Manifest.permission.SYSTEM_ALERT_WINDOW,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE

            }, MY_PERMISSION);

        }
        locationManager.requestLocationUpdates(provider, 400, 1, this);
    }
    @Override
    public void onLocationChanged(Location location) {
        lat = location.getLatitude();
        lng = location.getLongitude();
        new GetWeather().execute(Common.apiRequest(String.valueOf(lat), String.valueOf(lng)));
        Toast.makeText(getApplicationContext(), "on location Change ", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
    //a new class Get Weather
    public class GetWeather extends AsyncTask<String, Void, String> {
        
        ProgressDialog progressDialog = new ProgressDialog(getApplicationContext());
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog.setTitle("Please wait...");
            progressDialog.show();
        }

        @Override
        protected String doInBackground(String... strings) {
            String stream = null;
            String urlString = strings[0];
            Helper helper = new Helper();
            stream = helper.getHttpData(urlString);
            return stream;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if (s.contains("Error: Not found city")) {
                progressDialog.dismiss();
                return;
            }

            Gson gson = new Gson();
            Type myType = new TypeToken<String>() {
            }.getType();
            openWeatherMap = gson.fromJson(s, myType);
            progressDialog.dismiss();
            textCity.setText(String.format("%s.%s", openWeatherMap.getName(), openWeatherMap.getSys().getCountry()));
            textLastUpdate.setText(String.format("Last Update : %s", Common.getDate()));
            textDescriptor.setText(String.format("%s", openWeatherMap.getWeather().get(0).getDescription()));
            textHumidity.setText(String.format("%d", openWeatherMap.getMain().getHumidity()));
            textTime.setText(String.format("%s/%s", Common.unixTimeStandToDateTime(openWeatherMap.getSys().getSunrise()), Common.unixTimeStandToDateTime(openWeatherMap.getSys().getSunset())));
            textCelsius.setText(String.format("%.2f °C", openWeatherMap.getMain().getTemp()));
            Picasso.with(MainActivity.this).load(Common.getImage(openWeatherMap.getWeather().get(0).getIcon())).into(imageIcon);

        }
    }
}