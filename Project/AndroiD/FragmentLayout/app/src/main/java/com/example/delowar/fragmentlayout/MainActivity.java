package com.example.delowar.fragmentlayout;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends Activity implements View.OnClickListener{

    ImageView bd,al;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bd=findViewById(R.id.bdImage);
        al=findViewById(R.id.alImage);

        bd.setOnClickListener(this);
        al.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId()==R.id.bdImage)
        {
            bd.setVisibility(View.GONE);
            al.setVisibility(View.VISIBLE);
        }
        else if(view.getId()==R.id.alImage)
        {
            bd.setVisibility(View.VISIBLE);
            al.setVisibility(View.GONE);
        }
    }
}
