package com.example.finaldemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;

public class VendorModel extends DatabaseAccessor{
    public VendorModel(Context context){
        super(context);
    }

    public void addNewVendor(String vendor_name,String password, String qr_string, String location, int rating, String contact_details, String operating_times){

        SQLiteDatabase datab = db.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put("vendor_name", vendor_name);
        values.put("password", password);
        values.put("qr_string", qr_string);
        values.put("location", location);
        values.put("rating", Integer.valueOf(rating));
        values.put("contact_details", contact_details);
        values.put("operating_times", operating_times);

        datab.insert("Vendor", null, values);

        datab.close();
    }

    public boolean checkIfVendorExists(String vendor_name){
        SQLiteDatabase datab = db.getReadableDatabase();
        Cursor res = datab.rawQuery( "select * from Vendor where vendor_name = '"+ vendor_name+"'", null );

        if(!res.moveToFirst()){
            return false;
        }

        return true;
    }

    public ArrayList<String> getVendor(String vendor_name){
        SQLiteDatabase datab = db.getReadableDatabase();
        ArrayList<String> vendorRow = new ArrayList<>();

        Cursor res = datab.rawQuery( "select * from Vendor where vendor_name = '"+ vendor_name+"'", null );

        res.moveToFirst();
        for(int i=0; i<7; i++){
            vendorRow.add(res.getString(i));
        }
        return vendorRow;
    }

    public void deleteVendor(String vendor_name) {
        SQLiteDatabase datab = db.getWritableDatabase();

        datab.delete("Vendor", "ven_num=?", new String[]{vendor_name});
        datab.close();
    }


}
