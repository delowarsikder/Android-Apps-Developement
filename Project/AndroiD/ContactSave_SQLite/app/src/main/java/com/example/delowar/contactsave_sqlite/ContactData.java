package com.example.delowar.contactsave_sqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ContactData extends AppCompatActivity {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_data);
        textView=findViewById(R.id.showText);
        DataBaseCreate dataBaseCreate1=new DataBaseCreate(getApplicationContext());
        String [] data=dataBaseCreate1.user_Data();
        textView.setText(data[0]);
    }
}
