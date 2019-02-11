package com.example.delowar.registerlogin;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.print.PrinterId;
import android.widget.Toast;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static String DATABASE_NAME = "user_Account.db";
    private static String TABLE_NAME = "USER_DETAILS";
    private static String NAME = "Name";
    private static String ID = "Id";
    private static String EMAIL = "Email";
    private static String USERNAME = "Username";
    private static String PASSWORD = "Password";
    private static int VERSION = 1;
    private static String SELECT_ALL = "SELECT * FROM " + TABLE_NAME;
    private static String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;

    private static String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + NAME + " TEXT," +
            "" + EMAIL + " TEXT," + USERNAME + " TEXT," + PASSWORD + " TEXT);";

    Context context;


    public DatabaseHelper(Context context)//, String name, SQLiteDatabase.CursorFactory factory, int version)
    {
        super(context, DATABASE_NAME, null, VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL(CREATE_TABLE);
            Toast.makeText(context, "database in create ", Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            Toast.makeText(context, "Exception occurs " + e, Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        try {
            db.execSQL(DROP_TABLE);
            Toast.makeText(context, "Upgrade table", Toast.LENGTH_SHORT).show();
            onCreate(db);
        } catch (Exception e) {
            Toast.makeText(context, "Exception occurs " + e, Toast.LENGTH_SHORT).show();

        }

    }

    public long insertData(UserDetails userDetails) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME, userDetails.getName());
        contentValues.put(EMAIL, userDetails.getEmail());
        contentValues.put(USERNAME, userDetails.getUsername());
        contentValues.put(PASSWORD, userDetails.getPassword());

        long rowId = sqLiteDatabase.insert(TABLE_NAME, null, contentValues);
        return rowId;
    }


    public Boolean findAccount(String userName, String userPassword) {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(SELECT_ALL, null);
        Boolean result = false;

        if (cursor.getCount() == 0) {
            Toast.makeText(context, "No user name or Password Found", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()) {
                String username = cursor.getString(3).toString();
                String password = cursor.getString(4).toString();
                if ((userName.equals(username) && userPassword.equals(password)) &&
                        (userName!="" && password!="")) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

}
