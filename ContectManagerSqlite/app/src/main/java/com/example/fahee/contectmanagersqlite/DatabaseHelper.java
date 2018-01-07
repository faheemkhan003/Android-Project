package com.example.fahee.contectmanagersqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by fahee on 1/2/2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

   private static final String DATABASE_NAME="contacts.db";
    private static final String TABLE_NAME="contacts";
    private static int DATABASE_VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

        //SQLiteDatabase db = //error kia dy rha h

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql = "CREATE TABLE "+TABLE_NAME+" ( " +
                " id INTEGER PRIMARY KEY AUTOINCREMENT," +
                " name VARCHAR2(30), " +
                " Mobile_Number INT(20)," +
                " Email VARCHAR2(30) )";
        db.execSQL(sql);
       // db.execSQL("CREATE TABLE" + TABLE_NAME + "("+ID+" INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,MOBILE_NUMBER INTEGER,EMAIL TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTs" +TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String name,int mobile_number,String email){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",name);
        contentValues.put("Mobile_Number",mobile_number);
        contentValues.put("Email",email);

        long result = db.insert(TABLE_NAME,null,contentValues);
        if(result == -1)
         return false;
        else
            return true;

    }

    public Cursor getData(String mobile_number){
        SQLiteDatabase db = this.getWritableDatabase();
        String query= "SELECT * FROM " + TABLE_NAME +" WHERE Mobile_Number = '" + mobile_number + "'";

        Cursor cursor = db.rawQuery(query,null);
        return cursor;
    }

    public void deleteData(String mobile_number){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME,"Mobile_Number = '" + mobile_number + "'",null);
        //return false;
    }
    public void updateData(String number,String name,String email){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Email",email);
        contentValues.put("name",name);
        db.update(TABLE_NAME,contentValues,"Mobile_Number = '" + number + "'",null);

    }
}