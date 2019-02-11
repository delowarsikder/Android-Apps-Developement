package com.example.delowar.bit2byte;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends Activity {

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recycleId);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter=new MyViewHolder(this);
        recyclerView.setAdapter(adapter);


    }
}
