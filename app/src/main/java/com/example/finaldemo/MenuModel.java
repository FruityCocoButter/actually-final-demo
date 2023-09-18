package com.example.finaldemo;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;

public class MenuModel extends DatabaseAccessor{


    public MenuModel(){}

    public void addNewMenuItem(String item_name, String type, int price, String vendor_name){
        SQLiteDatabase datab = db.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("item_name", item_name);
        values.put("type", type);
        values.put("price", String.valueOf(price));
        values.put("vendor_name", vendor_name);

        datab.insert("MenuItem", null, values);

        datab.close();
    }

    public boolean checkIfMenuItemExists(String item_name){
        SQLiteDatabase datab = db.getReadableDatabase();
        Cursor res = datab.rawQuery( "select * from MenuItem where item_name = '"+ item_name+"'", null );

        if(!res.moveToFirst()){
            return false;
        }

        return true;
    }

    public ArrayList<String> getMenuItem(String item_name){
        SQLiteDatabase datab = db.getReadableDatabase();
        ArrayList<String> menuItemRow = new ArrayList<>();

        Cursor res = datab.rawQuery( "select * from MenuItem where item_name = '"+ item_name+"'", null );

        res.moveToFirst();
        for(int i=0; i < 4; i++){
            menuItemRow.add(res.getString(i));
        }

        return menuItemRow;
    }

    public ArrayList<ArrayList<String>> getAllMenuItems(String vendor_name){
        SQLiteDatabase datab = db.getReadableDatabase();
        ArrayList<ArrayList<String>> menuItemMatrix = new ArrayList<>();

        Cursor res = datab.rawQuery( "select * from MenuItem where vendor_name = '"+ vendor_name+"'", null );

        ArrayList<String> menuItemRow = null;
        res.moveToFirst();
        while(res.isAfterLast() == false) {
            for(int i=0; i < 4; i++){
                menuItemRow.add(res.getString(i));
            }
            menuItemMatrix.add(menuItemRow);
            res.moveToNext();
        }

        return menuItemMatrix;
    }

    public void deleteMenuItem(String item_name) {
        SQLiteDatabase datab = db.getWritableDatabase();

        datab.delete("MenuItem", "item_name=?", new String[]{item_name});
        datab.close();
    }

}
