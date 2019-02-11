package com.example.delowar.clock;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AnalogClock;
import android.widget.TextClock;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener{

    AnalogClock analogClock;
    TextClock textClock;
    //@android.support.annotation.RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        analogClock =(AnalogClock) findViewById(R.id.ac);
        textClock=(TextClock)findViewById(R.id.tc);

        analogClock.setOnClickListener(this);
        textClock.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.ac)
        {
            Toast.makeText(MainActivity.this,"Analog clock",Toast.LENGTH_SHORT).show();
        }
        if(view.getId()==R.id.tc)
        {
            Toast.makeText(MainActivity.this,"Digital Clock",Toast.LENGTH_SHORT).show();
        }
    }
}
