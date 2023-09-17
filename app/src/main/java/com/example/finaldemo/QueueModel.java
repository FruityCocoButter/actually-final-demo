package com.example.finaldemo;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;

public class QueueModel extends DatabaseAccessor{

    public QueueModel(){
    }

    public void addNewQueue(int ven_num, int queue_length, int order_freq, int day, int month, int year){
        SQLiteDatabase datab = db.getWritableDatabase();
        ContentValues values = new ContentValues();


        values.put("ven_num", ven_num);
        values.put("queue_length", String.valueOf(queue_length));
        values.put("order_freq", String.valueOf(order_freq));
        values.put("day", String.valueOf(day));
        values.put("month", String.valueOf(month));
        values.put("year", String.valueOf(year));

        datab.insert("Queue", null, values);

        datab.close();
    }

    public boolean checkIfQueueExists(int queue_num){
        SQLiteDatabase datab = db.getReadableDatabase();
        Cursor res = datab.rawQuery( "select * from Queue where queue_num = '"+ String.valueOf(queue_num)+"'", null );

        if(!res.moveToFirst()){
            return false;
        }

        return true;
    }

    public ArrayList<String> getQueue(int queue_num){
        SQLiteDatabase datab = db.getReadableDatabase();
        ArrayList<String> queueRow = new ArrayList<>();

        Cursor res = datab.rawQuery( "select * from Queue where queue_num = '"+ String.valueOf(queue_num)+"'", null );

        res.moveToFirst();
        for(int i=0; i < 7; i++){
            queueRow.add(res.getString(i));
        }

        return queueRow;
    }

    public void deleteQueue(int queue_num) {
        SQLiteDatabase datab = db.getWritableDatabase();

        datab.delete("Queue", "queue_num=?", new String[]{String.valueOf(queue_num)});
        datab.close();
    }

}
