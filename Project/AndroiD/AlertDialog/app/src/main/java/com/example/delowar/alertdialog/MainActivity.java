package com.example.delowar.alertdialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.sql.BatchUpdateException;

public class MainActivity extends Activity implements View.OnClickListener{

    Button button;
    AlertDialog.Builder alertDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=(Button)findViewById(R.id.bt);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        alertDialog=new AlertDialog.Builder(MainActivity.this);

        alertDialog.setMessage(R.string.message_text);
        alertDialog.setTitle(R.string.title_text);
        alertDialog.setIcon(R.drawable.pinterest);
        alertDialog.setCancelable(false);

        alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });

        alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //Toast.makeText(MainActivity.this,"Clicked the No option",Toast.LENGTH_SHORT).show();
                dialogInterface.cancel();
            }
        });
        alertDialog.setNeutralButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this,"Clicked the cancel option ",Toast.LENGTH_SHORT).show();
                    }
                }
        );

        AlertDialog alertDialog1=alertDialog.create();
        alertDialog1.show();


    }
}
