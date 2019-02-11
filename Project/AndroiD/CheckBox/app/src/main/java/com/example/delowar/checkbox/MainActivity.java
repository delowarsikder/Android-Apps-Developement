package com.example.delowar.checkbox;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    CheckBox milk,water,juice;
    TextView textView1,textView2;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        milk=(CheckBox) findViewById(R.id.cb1);
        water=(CheckBox) findViewById(R.id.cb2);
        juice=(CheckBox) findViewById(R.id.cb3);
        textView1=(TextView) findViewById(R.id.tv1);
        textView2=(TextView) findViewById(R.id.tv2);
        button=(Button) findViewById(R.id.b1);


       button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               StringBuilder stringBuilder=new StringBuilder();

               if(milk.isChecked())
               {
                   String value=milk.getText().toString();
                  stringBuilder.append(value+" is ordered "+"\n");

               }

               if(water.isChecked())
               {
                   String value=water.getText().toString();
                  stringBuilder.append(value+" is ordered "+"\n");

               }

               if(juice.isChecked())
               {
                   String value=juice.getText().toString();
                  stringBuilder.append(value+" is ordered "+"\n");

               }
               textView2.setText(stringBuilder);

           }
       });
    }
}
