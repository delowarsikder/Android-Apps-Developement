package com.example.delowar.databasestudent;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.NavigableMap;

public class DataBaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "Student.db";
    private static final String TABLE_NAME = "Student_Details";
    private static final int VERSION = 1;
    private static final String NAME = "Name";
    private static final String ROLL = "_Roll";
    private static final String AGE = "Age";
    private static final String GENDER = "Gender";
    private static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
    private static final String SELECT_ALL = "SELECT * FROM " + TABLE_NAME;
    private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" + ROLL + " INTEGER PRIMARY KEY, " + NAME + " TEXT," + AGE + " TEXT," + GENDER + " TEXT)";

    Context context;

    public DataBaseHelper(Context context)//, String name, SQLiteDatabase.CursorFactory factory, int version)
    {
        super(context, DATABASE_NAME, null, VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            Toast.makeText(context, "onCreate is called ", Toast.LENGTH_SHORT).show();
            db.execSQL(CREATE_TABLE);
        } catch (Exception e) {
            Toast.makeText(context, "Exception " + e, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        try {

            Toast.makeText(context, "onUpdate is called ", Toast.LENGTH_SHORT).show();
            db.execSQL(DROP_TABLE);
            onCreate(db);
        } catch (Exception e) {
            Toast.makeText(context, "Exception  " + e, Toast.LENGTH_SHORT).show();
        }

    }

    public long insertData(String Roll, String name, String gender, String age) {

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ROLL, Roll);
        contentValues.put(NAME, name);
        contentValues.put(AGE, age);
        contentValues.put(GENDER, gender);

        long rowId = sqLiteDatabase.insert(TABLE_NAME, null, contentValues);
        return rowId;
    }

    public Cursor displayData() {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(SELECT_ALL, null);
        return cursor;

    }

    boolean updateData(String roll, String name, String age, String gender) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ROLL, roll);
        contentValues.put(NAME, name);
        contentValues.put(AGE, age);
        contentValues.put(GENDER, gender);
        sqLiteDatabase.update(TABLE_NAME, contentValues, ROLL + " = ?", new String[]{roll});
        return true;
    }

    public int deleteData(String roll)
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        return sqLiteDatabase.delete(TABLE_NAME, ROLL + " = ?", new String[]{roll});
    }
}

