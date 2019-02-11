package com.example.delowar.gridview_university;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class customAdapter extends BaseAdapter {

    LayoutInflater inflater;
    String [] varsityName;
    int [] flags;
    Context context;

    public customAdapter(MainActivity mainActivity, String[] varsityName, int[] flag) {
        this.context=mainActivity;
        this.varsityName=varsityName;
        this.flags=flag;
    }

    @Override
    public int getCount() {
        return varsityName.length;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        if (view==null)
        {
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.temp_view,viewGroup,false);
        }
        ImageView imageView=view.findViewById(R.id.im1);
        TextView textView=view.findViewById(R.id.tvTemp1);
        imageView.setImageResource(flags[position]);
        textView.setText(varsityName[position]);
        return view;
    }
}
