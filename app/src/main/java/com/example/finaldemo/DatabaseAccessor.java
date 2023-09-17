package com.example.finaldemo;

import android.content.Context;

public class DatabaseAccessor {
    public static Database db;

    public DatabaseAccessor(){

    }

    public DatabaseAccessor(Context context){
        this.db = new Database(context);
    }
}
