package com.example.delowar.spinner;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends Activity {

    Spinner spinner;
    TextView textView;
    Button button;

    String [] varsityName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button=findViewById(R.id.bt);
        textView=findViewById(R.id.tv);
        spinner=findViewById(R.id.sp);
        varsityName=getResources().getStringArray(R.array.varsity_name);

        ArrayAdapter<String>arrayAdapter=new ArrayAdapter<>(this,R.layout.temp_layout,R.id.tempTv,varsityName);
        spinner.setAdapter(arrayAdapter);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String value=spinner.getSelectedItem().toString();
                textView.setText(value);
            }
        });
    }
}
