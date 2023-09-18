package com.example.finaldemo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AccountDisplay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Intent intent = getIntent();
        String person_number = intent.getStringExtra("username");

        Log.i("check_username_account", person_number);

        TextView username = (TextView) findViewById(R.id.username);
        username.setText(person_number);



    }
}
