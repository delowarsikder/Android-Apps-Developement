package com.example.delowar.recycleview;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.widget.Toast.LENGTH_SHORT;

public class MainActivity extends Activity {
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    List<List_Item>list_items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recycleId);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        list_items=new ArrayList<>();

        int i=0;
        while (i<=10)
        {
            List_Item list_item=new List_Item("Sample Name "+i,"Roll "+i);//,flag[i]);
            list_items.add(list_item);
            i++;
        }
        adapter=new MyAdapter(list_items,this);
        recyclerView.setAdapter(adapter);

        recyclerView.setOnClickListener(new AdapterView.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"The select item ", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
