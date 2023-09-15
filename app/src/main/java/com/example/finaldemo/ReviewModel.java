package com.example.finaldemo;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;

public class ReviewModel {
    Database db;

    public ReviewModel(Database db){
        this.db=db;
    }

    public void addNewReview(int review_num, String stu_num, String ven_num, int clean, int eff, int quality, String comment){
        SQLiteDatabase datab = db.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("review_num", String.valueOf(review_num));
        values.put("stu_num", stu_num);
        values.put("ven_num", ven_num);
        values.put("cleanliness", String.valueOf(clean));
        values.put("efficiency", String.valueOf(eff));
        values.put("quality", String.valueOf(quality));
        values.put("comment", comment);

        datab.insert("Review", null, values);

        datab.close();
    }

    public boolean checkIfReviewExists(int review_num){
        SQLiteDatabase datab = db.getReadableDatabase();
        Cursor res = datab.rawQuery( "select * from Review where review_num = '"+ String.valueOf(review_num)+"'", null );

        if(!res.moveToFirst()){
            return false;
        }

        return true;
    }

    public ArrayList<String> getReview(int review_num){
        SQLiteDatabase datab = db.getReadableDatabase();
        ArrayList<String> reviewRow = new ArrayList<>();

        Cursor res = datab.rawQuery( "select * from Review where review_num = '"+ String.valueOf(review_num)+"'", null );

        res.moveToFirst();
        for(int i=0; i < 7; i++){
            reviewRow.add(res.getString(i));
        }

        return reviewRow;
    }

    public void deleteReview(int review_num) {
        SQLiteDatabase datab = db.getWritableDatabase();

        datab.delete("Review", "review_num=?", new String[]{String.valueOf(review_num)});
        datab.close();
    }
}
