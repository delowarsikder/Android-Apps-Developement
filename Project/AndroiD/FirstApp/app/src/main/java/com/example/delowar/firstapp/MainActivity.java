package com.example.delowar.firstapp;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    Button b1,b2;
    TextView tv1;
    int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button) findViewById(R.id.bt1);
        b2=(Button) findViewById(R.id.bt2);
        tv1=(TextView) findViewById(R.id.tv);

        /*1.way
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv1.setText("login Button is click");
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv1.setText("logout button is clicked");
            }
        });*/


        /*2.way

            b1.setOnClickListener(this);
             b2.setOnClickListener(this);*/


        /*
        3.way
        Handler handler=new Handler();
        b1.setOnClickListener(handler);
        b2.setOnClickListener(handler);*/
    }
    /*class Handler implements  View.OnClickListener
    {

        @Override
        public void onClick(View view) {
            if(view.getId()==R.id.bt1)
            {
                tv1.setText("Login Button is Click");
            }
            if(view.getId()==R.id.bt2)
            {
                tv1.setText("Logout Button is Click");
            }
        }
    }*/
/*    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.bt1)
        {
            tv1.setText("Login Button is Clicked");
        }
        if(view.getId()==R.id.bt2)
        {
            tv1.setText("Logout Button is Clicked");
        }

    }*/

public void showMessage(View view)
{
    if(view.getId()==R.id.bt1)
    {
       // tv1.setText("Login Button is Click_ way4");
     //  toast message
       //Toast.makeText(MainActivity.this," Login Button is Clicked",Toast.LENGTH_SHORT).show();
       Toast toast=Toast.makeText(MainActivity.this," Login Button is Click",Toast.LENGTH_SHORT);
       toast.setGravity(Gravity.CENTER,0,150);
       toast.show();
        Log.d("tag","Login button");
        System.out.print("Login");
        }
    if(view.getId()==R.id.bt2)
    {
   //  toast
     Toast toast=Toast.makeText(MainActivity.this,"Logout Button is click",Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER,0,150);
        toast.show();
    Log.d("tag","Logout Button");
    System.out.print("Logout");
    }
}
}