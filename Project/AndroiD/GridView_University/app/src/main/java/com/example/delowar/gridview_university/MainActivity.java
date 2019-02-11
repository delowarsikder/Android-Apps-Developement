package com.example.delowar.gridview_university;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.Toast;

import static java.lang.String.format;

public class MainActivity extends Activity {

   GridView gridView;
    String [] varsityName;
    ImageView imageView;
    customAdapter adapter;
    int [] flag = {R.mipmap.ad,R.mipmap.ae,R.mipmap.af,R.mipmap.ag,R.mipmap.al,R.mipmap.am,R.mipmap.ao,R.mipmap.ar,
            R.mipmap.at,R.mipmap.au,R.mipmap.az,R.mipmap.ba,R.mipmap.bb,
            R.mipmap.bd,R.mipmap.be,R.mipmap.bf,R.mipmap.bg,R.mipmap.bh,R.mipmap.bi
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView =findViewById(R.id.gv);

        varsityName=getResources().getStringArray(R.array.varsity_name);

        adapter =new customAdapter(this,varsityName,flag);
        gridView.setAdapter(adapter);

        //toast message for custom adapter
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String name=varsityName[position];
                Toast.makeText(MainActivity.this,format("You have clicked %s",name),Toast.LENGTH_SHORT).show();
            }
        });
       /* ArrayAdapter<String>arrayAdapter;
        arrayAdapter=new ArrayAdapter<>(MainActivity.this,R.layout.temp_view,R.id.tvTemp1,varsityName);
        gridView.setAdapter(arrayAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String name=varsityName[position];
                Toast.makeText(MainActivity.this, format("Your selected varsity %s", name),Toast.LENGTH_SHORT).show();
            }
        });*/  //for set toast message  for array adapter

    }
}
