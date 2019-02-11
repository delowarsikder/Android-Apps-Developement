package com.example.delowar.spiner1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_SHORT;

public class MainActivity extends Activity {

    private  boolean select;
    Spinner spinner;
    String [] name;
    int [] flag = {R.mipmap.ad,R.mipmap.ae,R.mipmap.af,R.mipmap.ag,R.mipmap.al,R.mipmap.am,R.mipmap.ao,R.mipmap.ar,
            R.mipmap.at,R.mipmap.au,R.mipmap.az,R.mipmap.ba,R.mipmap.bb,
            R.mipmap.bd,R.mipmap.be,R.mipmap.bf,R.mipmap.bg,R.mipmap.bh,R.mipmap.bi };
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner=findViewById(R.id.spinnerId);
        name=getResources().getStringArray(R.array.varsity_name);
        CustomAdapter customAdapter=new CustomAdapter(name,flag,this);
        spinner.setAdapter(customAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(select==true)
                {
                    select=false;
                }
                else
                {
                    Toast.makeText(getApplicationContext(),name[i]+" Selected ", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }
}
