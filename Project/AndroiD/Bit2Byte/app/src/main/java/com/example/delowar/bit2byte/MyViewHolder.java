package com.example.delowar.bit2byte;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class MyViewHolder extends RecyclerView.Adapter<MyViewHolder.MyVH> {

    Context context;

    ArrayList<String>arrayList=new ArrayList<>();

    public MyViewHolder(MainActivity mainActivity) {
    }
    @NonNull
    @Override
    public MyVH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_layout,viewGroup,false);

        return  new MyVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyVH myVH, int i) {


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyVH extends RecyclerView.ViewHolder{

        public MyVH(@NonNull View itemView) {
            super(itemView);
        }
    }

}
