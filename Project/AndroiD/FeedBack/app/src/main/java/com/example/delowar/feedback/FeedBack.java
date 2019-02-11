package com.example.delowar.feedback;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FeedBack extends Activity implements View.OnClickListener {

    protected Button sendButton, clearButton;
    protected EditText nameEdit, emailEdit, messageEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_back);
        init();
        sendButton.setOnClickListener(this);
        clearButton.setOnClickListener(this);
    }

    private void init() {
        sendButton = findViewById(R.id.sendId);
        clearButton = findViewById(R.id.clearId);
        nameEdit = findViewById(R.id.nameId);
        emailEdit = findViewById(R.id.emailId);
        messageEdit = findViewById(R.id.messageID);
    }

    @Override
    public void onClick(View view) {
        try {

            String name = nameEdit.getText().toString();
            String email = emailEdit.getText().toString();
            String message = messageEdit.getText().toString();

            if (view.getId() == R.id.sendId) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/Email");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"delowarsikder099@gmail.com"});//receive email
                intent.putExtra(Intent.EXTRA_SUBJECT, "FeedBAck from App");
                intent.putExtra(Intent.EXTRA_TEXT, "Name :" + name + "\n Email :" + email + "\n Message :" + message);
                startActivity(Intent.createChooser(intent, "Feedback with"));
            } else if (view.getId() == R.id.clearId) {
                nameEdit.setText("");
                emailEdit.setText("");
                messageEdit.setText("");
            }
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "wrong input ", Toast.LENGTH_SHORT).show();
        }

    }
}
