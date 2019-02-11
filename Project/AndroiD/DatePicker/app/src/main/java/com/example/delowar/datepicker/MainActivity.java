package com.example.delowar.datepicker;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

public class MainActivity extends Activity {

     TextView textView;
     Button button;
     DatePicker datePicker;

     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=(TextView) findViewById(R.id.tv1);
        button=(Button)findViewById(R.id.b1);
        datePicker=(DatePicker)findViewById(R.id.dp1);

        textView.setText(currentDate());
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(currentDate());
            }
        });

    }

    String currentDate()
    {
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append("Current Date :");
        stringBuilder.append(datePicker.getDayOfMonth()+"/");
        stringBuilder.append(datePicker.getMonth()+1+"/");
        stringBuilder.append(datePicker.getYear());

        return stringBuilder.toString();
    }
}
