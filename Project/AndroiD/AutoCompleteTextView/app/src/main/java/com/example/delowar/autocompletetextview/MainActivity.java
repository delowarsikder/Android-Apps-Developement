package com.example.delowar.autocompletetextview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    AutoCompleteTextView autoCompleteTextView;

    String [] varsityName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        autoCompleteTextView=findViewById(R.id.autoTextId);
        varsityName=getResources().getStringArray(R.array.varsity_name);
        ArrayAdapter<String>arrayAdapter=new ArrayAdapter<String >(getApplicationContext(),
                android.R.layout.simple_list_item_1,varsityName);

        autoCompleteTextView.setThreshold(1);
        autoCompleteTextView.setAdapter(arrayAdapter);
        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String name=autoCompleteTextView.getText().toString();
                Toast.makeText(getApplicationContext(),"Selected varsity is "+name,Toast.LENGTH_SHORT).show();
            }
        });
    }
}
