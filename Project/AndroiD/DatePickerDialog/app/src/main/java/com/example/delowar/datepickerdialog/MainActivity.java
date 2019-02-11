package com.example.delowar.datepickerdialog;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.sql.BatchUpdateException;

public class MainActivity extends Activity implements View.OnClickListener{

    TextView textView;
    Button button;
    DatePickerDialog datePickerDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView=(TextView) findViewById(R.id.tv);
        button=(Button) findViewById(R.id.b1);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        DatePicker datePicker=new DatePicker(MainActivity.this);
        int currentYear=datePicker.getYear();
        int currentMonth=datePicker.getMonth()+1;
        int currentDay=datePicker.getDayOfMonth();

        datePickerDialog=new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                textView.setText("Date :"+i2+"/"+i1+"/"+i);
            }
        },currentYear,currentMonth,currentDay);
        datePickerDialog.show();
    }
}
