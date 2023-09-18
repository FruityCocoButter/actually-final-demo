package com.example.finaldemo;

import android.content.Context;

public class DatabaseAccessor {
    public static Database db =null;

    public DatabaseAccessor(){

    }

    public DatabaseAccessor(Context context){
        if(db ==null) {
            this.db = new Database(context);
        }

    }
}
