package com.example.delowar.recycleview;

import android.widget.ImageView;

public class List_Item {
    String Name;
    String Roll;
    int image;

    public List_Item(String name, String roll)//, int image)
    {
        Name = name;
        Roll = roll;
        this.image = image;
    }

    public String getName() {
        return Name;
    }

    public String getRoll() {
        return Roll;
    }

    public int getImage() {
        return image;
    }
}
