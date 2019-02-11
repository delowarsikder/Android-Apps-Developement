package com.example.delowar.spiner1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

class CustomAdapter extends BaseAdapter{

    TextView textView;
    ImageView imageView;
    String [] string;
    int [] flags;
    Context context;

    public CustomAdapter(String[] strings, int[] flag, Context context) {
        this.string = strings;
        this.flags = flag;
        this.context = context;
    }
    @Override
    public int getCount() {
        return string.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        if(view==null) {

            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.temp_layout, null, false);
        }

        textView= view.findViewById(R.id.tv);
        imageView= imageView.findViewById(R.id.im);
        imageView.setImageResource(flags[position]);
        textView.setText(string[position]);

        return view;
    }
}
