package com.example.firstandoidapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DataBase_Helper extends SQLiteOpenHelper {

    SQLiteDatabase sqdb;
    public DataBase_Helper(@Nullable Context context) {
        super(context, "FirstApp.db", null, 1);
        sqdb = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("create table Users (FirstName text, LastName text, Email text, Password text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void SaveDetails(String fname, String lname, String email, String password)
    {
        ContentValues cv = new ContentValues();

        cv.put("FirstName",fname);
        cv.put("LastName",lname);
        cv.put("Email",email);
        cv.put("Password",password);

        Log.i("database",sqdb.insert("Users",null,cv) + "");
    }

    public String getDetails(String email)

    {
        String det;

        Cursor c;

        c = sqdb.query("Users",null,"Email=?",new String[]{email},null,null,null);

        if (c.getCount() < 1)
        {
            return "Not Exists";
        }
        else {

            c.moveToFirst();

            det = c.getString(c.getColumnIndex("Password"));

            return det;
        }
    }


}
