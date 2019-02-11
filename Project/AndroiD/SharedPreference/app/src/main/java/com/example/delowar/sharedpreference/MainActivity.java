package com.example.delowar.sharedpreference;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button sendButton, loadButton;
    EditText userName, passWord;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        sendButton.setOnClickListener(this);
        loadButton.setOnClickListener(this);
    }
    private void init() {
        sendButton = findViewById(R.id.sendId);
        loadButton = findViewById(R.id.loadId);
        userName = findViewById(R.id.userID);
        passWord = findViewById(R.id.passID);
        textView = findViewById(R.id.showId);
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.sendId) {
            String name = userName.getText().toString();
            String password = passWord.getText().toString();

            SharedPreferences sharedPreferences = getSharedPreferences("userDetails", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("usernameKey", name);
            editor.putString("passwordKey", password);
            editor.commit();
            Toast.makeText(getApplicationContext(),"send button is clicked",Toast.LENGTH_SHORT).show();
            userName.setText("");
            passWord.setText("");

        } else if (v.getId() == R.id.loadId) {
            SharedPreferences sharedPreferences = getSharedPreferences("userDetails", Context.MODE_PRIVATE);


            if (sharedPreferences.contains("usernameKey") && sharedPreferences.contains("passwordKey")) {
                String name = sharedPreferences.getString("usernameKey", "Data not found !!");
                String password = sharedPreferences.getString("passwordKey", "Data not found !!");
                textView.setText(name + "\n" + password);

                Toast.makeText(getApplicationContext(),"Load button is clicked",Toast.LENGTH_SHORT).show();
            }
        }
    }
}
