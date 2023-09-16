package com.example.finaldemo;
import static java.lang.Math.abs;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.Iterator;

public class Database extends SQLiteOpenHelper{
    private static final String DB_NAME = "foodiesdb";
    private static final int DB_VERSION = 1;

    // creating a constructor for our database handler.
    public Database(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String cust_query = "CREATE TABLE Customer ("
                + "stu_num TEXT PRIMARY KEY, "
                + "password TEXT, "
                + "points INTEGER, "
                + "name TEXT,"
                + "surname TEXT,"
                + "email TEXT)";

        String vendor_query = "CREATE TABLE Vendor (ven_num INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "password TEXT, qr_string TEXT, location TEXT)";

        String menuitem_query = "CREATE TABLE MenuItem (item_name TEXT PRIMARY KEY, "
                + "type TEXT, price INTEGER)";

        String queue_query = "CREATE TABLE Queue (queue_num INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "ven_num TEXT, queue_length INTEGER, order_freq INTEGER, "
                + "day INTEGER, month INTEGER, year INTEGER)";

        String review_query = "CREATE TABLE Review (review_num INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "std_num, ven_num, cleanliness INTEGER, efficiency INTEGER, quality INTEGER, "
                + "cust_service INTEGER, comment TEXT)";

        String voucher_query = "CREATE TABLE Voucher (voucher_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "std_num TEXT, ven_num TEXT, day INTEGER, month INTEGER, year INTEGER)";


        db.execSQL(cust_query);
        db.execSQL(vendor_query);
        db.execSQL(menuitem_query);
        db.execSQL(queue_query);
        db.execSQL(review_query);
        db.execSQL(voucher_query);

        Log.i("why","hello");
    }
    public void addNewCustomer(String stu_num, String password, int points){
        SQLiteDatabase datab = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("stu_num", stu_num);
        values.put("password", password);
        values.put("points", String.valueOf(points));

        datab.insert("Customer", null, values);

        datab.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // this method is called to check if the table exists already.
        db.execSQL("DROP TABLE IF EXISTS Customer");
        db.execSQL("DROP TABLE IF EXISTS Vendor");
        db.execSQL("DROP TABLE IF EXISTS MenuItem");
        db.execSQL("DROP TABLE IF EXISTS Queue");
        db.execSQL("DROP TABLE IF EXISTS Review");
        db.execSQL("DROP TABLE IF EXISTS Voucher");
        onCreate(db);
    }
}
