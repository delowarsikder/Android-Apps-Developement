package com.example.delowar.timepicker;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends Activity {

    TimePicker timePicker;
    Button button;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView=(TextView) findViewById(R.id.tv1);

        button=(Button) findViewById(R.id.bt);
        timePicker=(TimePicker)findViewById(R.id.tp);
       // timePicker.setIs24HourView(true);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String string=timePicker.getCurrentHour()+" : "+timePicker.getCurrentMinute();
                textView.setText(string);
            }
        });
    }
}
