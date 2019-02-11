package com.example.delowar.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    EditText userName, passWord;
    Button logIn;
    int count = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        textView.setText("Number of attempt : 3");

        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String username = userName.getText().toString();
                    String password = passWord.getText().toString();
                    if (username.equals("admin") && password.equals("1234")) {
                        Intent intent = new Intent(getApplicationContext(), WellCome.class);
                        startActivity(intent);
                    } else {
                        count--;
                        textView.setText("Number of attempt : " + count);
                        Toast.makeText(getApplicationContext(), "wrong user name or password ", Toast.LENGTH_SHORT).show();
                        Toast.makeText(getApplicationContext(), "Please Enter Correct username and passsword ", Toast.LENGTH_SHORT).show();
                        userName.setText("");
                        passWord.setText("");
                        if (count <= 0) {
                            logIn.setEnabled(false);
                            Toast.makeText(getApplicationContext(),"Your trial is finished ",Toast.LENGTH_SHORT).show();
                        }
                    }
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Please Enter Correct username and passsword ", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void init() {
        userName = findViewById(R.id.userId);
        passWord = findViewById(R.id.passwordId);
        textView = findViewById(R.id.textId);
        logIn = findViewById(R.id.loginId);
    }
}
