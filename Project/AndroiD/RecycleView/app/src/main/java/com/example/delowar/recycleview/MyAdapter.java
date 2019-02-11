package com.example.delowar.recycleview;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import static com.example.delowar.recycleview.R.id.layoutId;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<List_Item>list_items;
    private Context context;

    int [] flag = {R.mipmap.bd,R.mipmap.ba,R.mipmap.af,R.mipmap.ag,R.mipmap.al,R.mipmap.am,R.mipmap.ao,R.mipmap.ar,
            R.mipmap.at,R.mipmap.au};


    public MyAdapter(List<List_Item> list_items, Context context) {
        this.list_items = list_items;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item,viewGroup,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        List_Item list_items1=list_items.get(i);
        viewHolder.NameText.setText(list_items1.getName());
        viewHolder.RollText.setText(list_items1.getRoll());
        viewHolder.imageView.setImageResource(flag[i]);
        //viewHolder.imageView.setImageResource(list_items1.getImage());

//        imageView.setImageResource(flags[position]);


    }

    @Override
    public int getItemCount() {
        return list_items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView NameText,RollText;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            NameText=(TextView) itemView.findViewById(R.id.nameId);
            RollText=(TextView) itemView.findViewById(R.id.rollId);
            imageView = itemView.findViewById(R.id.imageId);
        }
    }
}
