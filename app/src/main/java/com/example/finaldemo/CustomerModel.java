package com.example.finaldemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;

public class CustomerModel {
    Database db;
    public CustomerModel(Database db){
        this.db=db;
    }

    public void addNewCustomer(String stu_num, String password, int points){
        SQLiteDatabase datab = db.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("stu_num", stu_num);
        values.put("password", password);
        values.put("points", String.valueOf(points));

        datab.insert("Customer", null, values);

        datab.close();
    }

    public boolean checkIfCustomerExists(String stu_num){
        SQLiteDatabase datab = db.getReadableDatabase();
        Cursor res = datab.rawQuery( "select * from Customer where stu_num = '"+ stu_num+"'", null );

        if(!res.moveToFirst()){
            return false;
        }

        return true;
    }

    public ArrayList<String> getCustomer(String stu_num){
        SQLiteDatabase datab = db.getReadableDatabase();
        ArrayList<String> customerRow = new ArrayList<>();

        Cursor res = datab.rawQuery( "select * from Customer where stu_num = '"+ stu_num+"'", null );

        res.moveToFirst();
        for(int i=0; i < 3;i++){
            customerRow.add(res.getString(i));
        }

        return customerRow;
    }

    public void deleteCustomer(String stu_num) {
        SQLiteDatabase datab = db.getWritableDatabase();

        datab.delete("Customer", "stu_num=?", new String[]{stu_num});
        datab.close();
    }

}
