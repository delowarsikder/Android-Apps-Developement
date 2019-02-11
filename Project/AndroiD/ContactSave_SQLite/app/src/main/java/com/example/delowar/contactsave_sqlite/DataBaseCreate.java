package com.example.delowar.contactsave_sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract;
import android.widget.Toast;

public class DataBaseCreate extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "Phone Book.db";
    private static final String TABLE_HEADER = "Contact_List";
    private static final String TABLE_NAME = "Name";
    private static final String TABLE_ID = "Id";
    private static final int version = 2;
    private static final String TABLE_CONTACT = "Phone_Number";
    private static final String tableDetails = "CREATE TABLE " + TABLE_HEADER + "(" + TABLE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + TABLE_NAME + " TEXT," + TABLE_CONTACT + " TEXT )";

    Context context;

    public DataBaseCreate(Context context)//, String name, SQLiteDatabase.CursorFactory factory, int version)
    {
        super(context, DATABASE_NAME, null, version);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            Toast.makeText(context, "On create Method is called", Toast.LENGTH_SHORT).show();
            db.execSQL(tableDetails);
        } catch (Exception e) {
            Toast.makeText(context, "Exception ", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    //adding data in database

    public void addData(DataTemp dataTemp) {

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(TABLE_NAME, dataTemp.getNameUser());
        contentValues.put(TABLE_CONTACT, dataTemp.getContactUser());
        sqLiteDatabase.insert(TABLE_HEADER, null, contentValues);
        sqLiteDatabase.close();
    }

    ///receive name from database and showing
    String[] user_Data() {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        String Name = "SELECT * FROM " + TABLE_HEADER;
        Cursor cursor = sqLiteDatabase.rawQuery(Name, null);
        String[] receive_data = new String[cursor.getCount()];
        cursor.moveToFirst();
        if (cursor.moveToFirst()) {
            int counter = 0;
            do {
                receive_data[counter] = "Name :" + cursor.getString(cursor.getColumnIndex(TABLE_NAME + ""))
                        + "\n" + "Name :" + cursor.getString(cursor.getColumnIndex(TABLE_CONTACT + ""));
                counter++;
            } while (cursor.moveToNext());
        }
        return receive_data;
    }

}
