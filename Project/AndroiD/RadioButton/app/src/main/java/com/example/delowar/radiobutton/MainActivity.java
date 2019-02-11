package com.example.delowar.radiobutton;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    RadioButton radioButton1,radioButton2;
    TextView textView1,textView2,textView3;
    Button button1,button2;
    RadioGroup radioGroup;
    RatingBar ratingBar;
    float rate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup=(RadioGroup)findViewById(R.id.rg1);
        textView1=(TextView)findViewById(R.id.tv1);
        textView2=(TextView)findViewById(R.id.tv2);
        textView3=(TextView)findViewById(R.id.tv3);
        button1=(Button) findViewById(R.id.b1);
        button2=(Button) findViewById(R.id.b2);
        ratingBar=(RatingBar) findViewById(R.id.rB);

        textView3.setText("value :"+ratingBar.getProgress());

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                rate=v;
                textView3.setText("value :"+v);
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectId=radioGroup.getCheckedRadioButtonId();
                radioButton1=(RadioButton) findViewById(selectId);
                String value=radioButton1.getText().toString();

                textView2.setText("You have selected "+value);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"Thanks for giving ratting "+rate,Toast.LENGTH_SHORT).show();
//                Toast toast=new Toast(MainActivity.this);
//                toast.setGravity(Gravity.CENTER,0,-150);
//                toast.setView();
//                toast.setDuration(Toast.LENGTH_SHORT);
//                toast.show();
            }
        });

    }
}
