package com.example.delowar.kuethelpdesk;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {

    LayoutInflater inflater;
    String[] departMent;
    Context context;

    public CustomAdapter(String[] departMent, Context context) {
        this.departMent = departMent;
        this.context = context;
    }

    @Override
    public int getCount() {
        return departMent.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        if (view == null) {
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.temp_layout, viewGroup, false);
        }

        TextView textView = view.findViewById(R.id.tv_show);
        textView.setText(departMent[position]);

        return view;
    }
}

