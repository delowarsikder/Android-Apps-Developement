package com.example.delowar.kuethelpdesk;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import static java.lang.String.format;

public class EEEActivity extends AppCompatActivity {
    ListView listVieweee;
    String[] eeeSemester;
    CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eee);
        init();
        eeeSemester = getResources().getStringArray(R.array.semester_item);
        adapter = new CustomAdapter(eeeSemester, getApplicationContext());
        listVieweee.setAdapter(adapter);
        listener();
    }


    private void listener() {

        listVieweee.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String name = eeeSemester[position];
                Toast.makeText(getApplicationContext(), format(" EEE You have clicked %s", name), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void init() {
        listVieweee = findViewById(R.id.list_itemEEE);
    }

}
