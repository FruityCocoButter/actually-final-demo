package com.example.finaldemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;

public class CustomerModel extends DatabaseAccessor{
    public CustomerModel(Context context){
        super(context);
    }

    public void addNewCustomer(String stu_num, String password, int points, String name, String surname, String email){
        SQLiteDatabase datab =db.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put("stu_num", stu_num);
        values.put("password", password);
        values.put("points", String.valueOf(points));
        values.put("name", name);
        values.put("surname", surname);
        values.put("email", email);

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
        for(int i=0; i < 6;i++){
            customerRow.add(res.getString(i));
        }

        return customerRow;
    }

    public int getPoints(String stu_num){
        ArrayList<String> customerRow = this.getCustomer(stu_num);
        return Integer.valueOf(customerRow.get(2));
    }

    public void setPoints(String stu_num, int new_points_num){
        ArrayList<String> customerRow = this.getCustomer(stu_num);
        this.deleteCustomer(stu_num);
        addNewCustomer(stu_num, customerRow.get(1), new_points_num, customerRow.get(3), customerRow.get(4), customerRow.get(5));
    }

    public String getName(String stu_num){
        ArrayList<String> customerRow = this.getCustomer(stu_num);
        return customerRow.get(3);
    }

    public String getSurname(String stu_num){
        ArrayList<String> customerRow = this.getCustomer(stu_num);
        return customerRow.get(4);
    }


    public void deleteCustomer(String stu_num) {
        SQLiteDatabase datab = db.getWritableDatabase();

        datab.delete("Customer", "stu_num=?", new String[]{stu_num});
        datab.close();
    }

}
