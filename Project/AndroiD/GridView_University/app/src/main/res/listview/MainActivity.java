package com.example.delowar.listview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.lang.reflect.Array;

import static java.lang.String.format;

public class MainActivity extends Activity {

    ListView listView;
    SearchView searchView;
    String [] varsityName;
    customAdapter adapter;
    ImageView imageView;
    int [] flag = {R.mipmap.ad,R.mipmap.ae,R.mipmap.af,R.mipmap.ag,R.mipmap.al,R.mipmap.am,R.mipmap.ao,R.mipmap.ar,
            R.mipmap.at,R.mipmap.au,R.mipmap.az,R.mipmap.ba,R.mipmap.bb,
            R.mipmap.bd,R.mipmap.be,R.mipmap.bf,R.mipmap.bg,R.mipmap.bh,R.mipmap.bi
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView =findViewById(R.id.lw);
        searchView=findViewById(R.id.searchview);

        varsityName=getResources().getStringArray(R.array.versity_name);

          adapter =new customAdapter(this,varsityName,flag);
        listView.setAdapter(adapter);

        //toast message for custom adapter
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String name=varsityName[position];
                Toast.makeText(MainActivity.this,format("You have clicked %s",name),Toast.LENGTH_SHORT).show();
            }
        });
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s){
                return false;
            }
        });
        //for set toast message  for array adapter
       /* ArrayAdapter<String>arrayAdapter;
        arrayAdapter=new ArrayAdapter<>(MainActivity.this,R.layout.temp_view,R.id.tvTemp1,varsityName);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String name=varsityName[position];
                Toast.makeText(MainActivity.this, format("Your selected varsity %s", name),Toast.LENGTH_SHORT).show();
            }
        });*/
    }
}
