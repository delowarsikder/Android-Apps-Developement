package com.example.delowar.kuethelpdesk;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import static java.lang.String.format;

public class CSEActivity extends AppCompatActivity {
    ListView listViewcse;
    String[] cseSemester;
    CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cse);
        init();
        cseSemester = getResources().getStringArray(R.array.semester_item);
        adapter = new CustomAdapter(cseSemester, getApplicationContext());
        listViewcse.setAdapter(adapter);
        listener();
    }


    private void listener() {

        listViewcse.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String name = cseSemester[position];

                if (name.equals("1-1")) {
                    Intent intent=new Intent(getApplicationContext(),ShowActivity.class);
                    startActivity(intent);

                } else if (name.equals("1-2")) {

                } else if (name.equals("2-1")) {

                } else if (name.equals("2-2")) {

                } else if (name.equals("3-1")) {

                } else if (name.equals("3-2")) {

                } else if (name.equals("4-1")) {

                } else if (name.equals("4-2")) {

                }

                Toast.makeText(getApplicationContext(), format(" CSE You have clicked %s", name), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void init() {
        listViewcse = findViewById(R.id.list_itemCSE);
    }

}
