package com.example.delowar.registerlogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    EditText signUpName, signUpEmail, signUpPassword, signUpUsername;
    Button signUpButton;
    UserDetails userDetails;

    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        userDetails = new UserDetails();
        databaseHelper = new DatabaseHelper(this);
        initSignUpActivity();
        listener();
    }

    private void listener() {
        signUpButton.setOnClickListener(this);
    }

    private void initSignUpActivity() {
        signUpName = findViewById(R.id.signUpNameId);
        signUpEmail = findViewById(R.id.signUpEmailID);
        signUpPassword = findViewById(R.id.signUppasswordId);
        signUpUsername = findViewById(R.id.signUpuserameId);
        signUpButton = findViewById(R.id.signUpID);
    }

    @Override
    public void onClick(View v) {
        String name = signUpName.getText().toString();
        String email = signUpEmail.getText().toString();
        String password = signUpPassword.getText().toString();
        String username = signUpUsername.getText().toString();

        if (v.getId() == R.id.signUpID) {
            userDetails.setEmail(email);
            userDetails.setName(name);
            userDetails.setPassword(password);
            userDetails.setUsername(username);

            if (name.equals("") || email.equals("") || password.equals("") || username.equals("")) {
                Toast.makeText(getApplicationContext(), "Please Insert Data again", Toast.LENGTH_SHORT).show();
            } else {
                long rowId = databaseHelper.insertData(userDetails);
                Toast.makeText(getApplicationContext(), "sign up successfully", Toast.LENGTH_SHORT).show();
                signUpName.setText("");
                signUpUsername.setText("");
                signUpPassword.setText("");
                signUpEmail.setText("");
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        }
    }
}
