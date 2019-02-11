package com.example.delowar.registerlogin;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.InputStream;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText signInName, signInPassword;
    Button signInButton, createButton;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initMainActivity();
        listener();
        databaseHelper = new DatabaseHelper(this);
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();
    }

    private void listener() {
        signInButton.setOnClickListener(this);
        createButton.setOnClickListener(this);
    }

    private void initMainActivity() {
        signInName = findViewById(R.id.signInUsernameID);
        signInPassword = findViewById(R.id.signInPasswordID);
        signInButton = findViewById(R.id.signInButtonID);
        createButton = findViewById(R.id.createId);
    }

    @Override
    public void onClick(View v) {
        String userName=signInName.getText().toString();
        String userPassword=signInPassword.getText().toString();
        if (v.getId() == R.id.signInButtonID) {

            Boolean result=databaseHelper.findAccount(userName,userPassword);

            if(result==true)
            {
                Intent intent=new Intent(getApplicationContext(),WellComeScreen.class);
                startActivity(intent);
            }
            else {
                Toast.makeText(getApplicationContext(),"InCorrect password or User name",Toast.LENGTH_SHORT).show();
            }

        } else if (v.getId() == R.id.createId) {
            Intent intent = new Intent(getApplicationContext(), SignUpActivity.class);
            startActivity(intent);
        }
        signInName.setText("");
        signInPassword.setText("");
    }
}
