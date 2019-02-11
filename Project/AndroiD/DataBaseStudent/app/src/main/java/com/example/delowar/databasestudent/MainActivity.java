package com.example.delowar.databasestudent;

import android.app.Activity;
import android.app.AlertDialog;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {

    EditText nameText, genderText, ageText, rollText;
    Button saveText, showText, updateText,deleteText;
    DataBaseHelper dataBaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        dataBaseHelper = new DataBaseHelper(this);

        SQLiteDatabase sqLiteDatabase = dataBaseHelper.getWritableDatabase();
        setListener();
    }

    private void setListener() {
        saveText.setOnClickListener(this);
        showText.setOnClickListener(this);
        updateText.setOnClickListener(this);
        deleteText.setOnClickListener(this);
    }

    private void init() {
        nameText = findViewById(R.id.name_Id);
        genderText = findViewById(R.id.gender_Id);
        ageText = findViewById(R.id.age_Id);
        rollText = findViewById(R.id.roll_Id);
        saveText = findViewById(R.id.saveId);
        showText = findViewById(R.id.showId);
        updateText = findViewById(R.id.updateId);
        deleteText=findViewById(R.id.deleteId);


    }

    @Override
    public void onClick(View v) {
        String name = nameText.getText().toString();
        String gender = genderText.getText().toString();
        String age = ageText.getText().toString();
        String roll = rollText.getText().toString();

        if (v.getId() == R.id.saveId) {
            long rowId = dataBaseHelper.insertData(roll, name, gender, age);
            if (rowId == -1) {
                Toast.makeText(getApplicationContext(), "Insert Data Unsuccessful", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplicationContext(), rowId + "  successfully insert", Toast.LENGTH_SHORT).show();
            }

            //clear text item
            nameText.setText("");
            rollText.setText("");
            genderText.setText("");
            ageText.setText("");

        }

        else if (v.getId() == R.id.showId) {
            Cursor cursor = dataBaseHelper.displayData();
            if (cursor.getCount() == 0) {
                //there will no data
                showData("Error", "No data Found!!");
                return;
            }
            StringBuffer stringBuffer = new StringBuffer();
            while (cursor.moveToNext()) {
                stringBuffer.append("Roll :" + cursor.getString(0) + "\n");
                stringBuffer.append("Name :" + cursor.getString(1) + "\n");
                stringBuffer.append("Age :" + cursor.getString(2) + "\n");
                stringBuffer.append("Gender :" + cursor.getString(3) + "\n\n");
            }
            showData("Result set", stringBuffer.toString());
        }

        else if (v.getId() == R.id.updateId) {
            boolean isUpdate = dataBaseHelper.updateData(roll, name, age, gender);
            if (isUpdate) {
                Toast.makeText(getApplicationContext(), "Update data Successfully", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplicationContext(), "Update data UnSuccessful", Toast.LENGTH_SHORT).show();
            }

            //clear text item
            nameText.setText("");
            rollText.setText("");
            genderText.setText("");
            ageText.setText("");
        }

        else if (v.getId()==R.id.deleteId)
        {
           int value= dataBaseHelper.deleteData(roll);
           if(value>0)
           {
               Toast.makeText(getApplicationContext(), "Delete date Successfully", Toast.LENGTH_SHORT).show();

           }
           else {
               Toast.makeText(getApplicationContext(), "Delete data UnSuccessful", Toast.LENGTH_SHORT).show();

           }

            //clear text item
            nameText.setText("");
            rollText.setText("");
            genderText.setText("");
            ageText.setText("");
        }
    }


    private void showData(String result_set, String string) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle(result_set);
        alertDialog.setMessage(string);
        alertDialog.setCancelable(true);
        alertDialog.show();
    }

}
