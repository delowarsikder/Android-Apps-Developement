package com.example.delowar.demofail;

import android.app.MediaRouteButton;
import android.media.Image;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    ImageView Image1,Image2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Image1=(ImageView) findViewById(R.id.imB1);
        Image2=(ImageView) findViewById(R.id.imB2);

        Image1.setOnClickListener(this);
        Image2.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.imB1)
        {
            Toast toast=Toast.makeText(MainActivity.this,"Ring is clicked",Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER,0,-150);
            toast.show();
        }
        if(view.getId()==R.id.imB2)
        {
            Toast toast=Toast.makeText(MainActivity.this,"Eid Mubarok",Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER,0,-100);
            toast.show();
        }

    }
}
