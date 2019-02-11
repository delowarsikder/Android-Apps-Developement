package com.example.delowar.contactsave_sqlite;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText userName, userContact;
    Button saveButton, showButton;

    final DataBaseCreate dataBaseCreate = new DataBaseCreate(getApplicationContext());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        saveButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = userName.getText().toString();
                String contact = userContact.getText().toString();
                DataTemp dataTemp = new DataTemp(name, contact);
                dataBaseCreate.addData(dataTemp);
                Toast.makeText(getApplicationContext(), "Add data successfully!!!", Toast.LENGTH_SHORT).show();
            }
        });

        showButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ContactData.class);
                startActivity(intent);
            }
        });
    }

    private void init() {
        userName = findViewById(R.id.nameId);
        userContact = findViewById(R.id.numberId);
        saveButton = findViewById(R.id.saveId);
        showButton = findViewById(R.id.showId);

    }
}