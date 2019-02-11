package com.example.delowar.countryprofile;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener {

    Button buttonbd, buttonin, buttonpk;
    Intent intent;
    AlertDialog.Builder alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonbd = (Button) findViewById(R.id.bD);
        buttonin = (Button) findViewById(R.id.ind);
        buttonpk = (Button) findViewById(R.id.pk);

        buttonbd.setOnClickListener(this);
        buttonin.setOnClickListener(this);
        buttonpk.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.bD) {
            intent = new Intent(getApplicationContext(), ProfileCountry.class);
            intent.putExtra("name", "Bangladesh");
            startActivity(intent);
        }

        if (view.getId() == R.id.ind) {
            intent = new Intent(MainActivity.this, ProfileCountry.class);
            intent.putExtra("name", "India");
            startActivity(intent);
        }

        if (view.getId() == R.id.pk) {
            intent = new Intent(MainActivity.this, ProfileCountry.class);
            intent.putExtra("name", "Pakistan");
            startActivity(intent);
        }

    }

    @Override
    public void onBackPressed() {
        // super.onBackPressed();
        alertDialog = new AlertDialog.Builder(MainActivity.this);
        alertDialog.setIcon(R.mipmap.bd);//use question icon
        alertDialog.setCancelable(false);
        alertDialog.setMessage(R.string.message_txt);
        alertDialog.setTitle(R.string.title_txt);

        alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });

        alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });

        AlertDialog alertDialog1 = alertDialog.create();
        alertDialog1.show();
    }
}
