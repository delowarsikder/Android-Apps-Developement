package com.example.delowar.timepickerdialog;

import android.app.Activity;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import java.sql.BatchUpdateException;

public class MainActivity extends Activity implements View.OnClickListener{

    TextView textView;
    Button button;
    TimePickerDialog timePickerDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView=(TextView)findViewById(R.id.tv);
        button=(Button)findViewById(R.id.bt);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        TimePicker timePicker=new TimePicker(MainActivity.this);
        int currentHour=timePicker.getCurrentHour();
        int currentMinute=timePicker.getCurrentMinute();
        timePickerDialog=new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int i, int i1) {
                textView.setText("Current Time : "+i+" : "+i1);
            }
        },currentHour,currentMinute,false);
        timePickerDialog.show();
    }
}
