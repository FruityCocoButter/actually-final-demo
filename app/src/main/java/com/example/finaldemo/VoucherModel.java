package com.example.finaldemo;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;

public class VoucherModel extends DatabaseAccessor{

    public VoucherModel(){
    }

    public void addNewVoucher(String stu_num, int ven_num, int day, int month, int year){
        SQLiteDatabase datab = db.getWritableDatabase();
        ContentValues values = new ContentValues();


        values.put("stu_num", stu_num);
        values.put("ven_len", ven_num);
        values.put("day", String.valueOf(day));
        values.put("month", String.valueOf(month));
        values.put("year", String.valueOf(year));

        datab.insert("Voucher", null, values);

        datab.close();
    }

    public boolean checkIfVoucherExists(int voucher_id){
        SQLiteDatabase datab = db.getReadableDatabase();
        Cursor res = datab.rawQuery( "select * from Voucher where voucher_id = '"+ String.valueOf(voucher_id)+"'", null );

        if(!res.moveToFirst()){
            return false;
        }

        return true;
    }

    public ArrayList<String> getVoucher(int voucher_id){
        SQLiteDatabase datab = db.getReadableDatabase();
        ArrayList<String> voucherRow = new ArrayList<>();

        Cursor res = datab.rawQuery( "select * from Voucher where voucher_id = '"+ String.valueOf(voucher_id)+"'", null );

        res.moveToFirst();
        for(int i=0; i < 6; i++){
            voucherRow.add(res.getString(i));
        }

        return voucherRow;
    }

    public void deleteVoucher(int voucher_id) {
        SQLiteDatabase datab = db.getWritableDatabase();

        datab.delete("Voucher", "voucher_id=?", new String[]{String.valueOf(voucher_id)});
        datab.close();
    }


}
