package com.example.finaldemo;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;

public class VendorModel extends DatabaseAccessor{
    public VendorModel(){
    }

    public void addNewVendor(String password, String qr_string, String location){
        SQLiteDatabase datab = db.getWritableDatabase();
        ContentValues values = new ContentValues();


        values.put("password", password);
        values.put("qr_string", qr_string);
        values.put("location", location);

        datab.insert("Vendor", null, values);

        datab.close();
    }

    public boolean checkIfVendorExists(int ven_num){
        SQLiteDatabase datab = db.getReadableDatabase();
        Cursor res = datab.rawQuery( "select * from Vendor where ven_num = '"+ String.valueOf(ven_num)+"'", null );

        if(!res.moveToFirst()){
            return false;
        }

        return true;
    }

    public ArrayList<String> getVendor(int ven_num){
        SQLiteDatabase datab = db.getReadableDatabase();
        ArrayList<String> vendorRow = new ArrayList<>();

        Cursor res = datab.rawQuery( "select * from Vendor where ven_num = '"+ String.valueOf(ven_num)+"'", null );

        res.moveToFirst();
        for(int i=0; i<4; i++){
            vendorRow.add(res.getString(i));
        }
        return vendorRow;
    }

    public void deleteVendor(int ven_num) {
        SQLiteDatabase datab = db.getWritableDatabase();

        datab.delete("Vendor", "ven_num=?", new String[]{String.valueOf(ven_num)});
        datab.close();
    }


}
