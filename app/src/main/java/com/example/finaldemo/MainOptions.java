package com.example.finaldemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.widget.TextView;

public class MainOptions extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_options);

        Intent intent = getIntent();
        String vendor_name = intent.getStringExtra("vendor_name");
        String username = intent.getStringExtra("username");

        TextView vendor_name_view = (TextView) findViewById(R.id.vendor_name);
        vendor_name_view.setText(vendor_name);

        Button menu_button = (Button) findViewById(R.id.menu);
        Button review_button = (Button) findViewById(R.id.review);
        Button info_button = (Button) findViewById(R.id.vendor_info);

        info_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), VendorInfo.class);
                intent.putExtra("vendor_name", vendor_name);
                view.getContext().startActivity(intent);
            }
        });

        review_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), ReviewPage.class);
                intent.putExtra("vendor_name", vendor_name);
                intent.putExtra("username", username);
                view.getContext().startActivity(intent);
            }
        });

        menu_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), MenuPage.class);
                intent.putExtra("vendor_name", vendor_name);
                view.getContext().startActivity(intent);
            }
        });

    }
}