package com.example.delowar.kuethelpdesk;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import static java.lang.String.format;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    String[] departmentName;
    CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        departmentName = getResources().getStringArray(R.array.department_name);
        adapter = new CustomAdapter(departmentName, this);
        listView.setAdapter(adapter);

        listener();
    }

    private void listener() {

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String name = departmentName[position];
                if(name.equals("CSE"))
                {
                    Intent intent=new Intent(getApplicationContext(),CSEActivity.class);
                    startActivity(intent);
                }
                else if(name.equals("EEE"))
                {
                    Intent intent=new Intent(getApplicationContext(),EEEActivity.class);
                    startActivity(intent);
                }

                Toast.makeText(MainActivity.this, format("MAIN You have clicked %s", name), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void init() {
        listView = findViewById(R.id.listViewId);
    }
}
