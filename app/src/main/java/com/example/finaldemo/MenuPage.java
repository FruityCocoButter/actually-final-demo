package com.example.finaldemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MenuPage extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vendor_menu);

        VendorController vendCont = new VendorController(this);

        LinearLayout menu_screen = (LinearLayout) findViewById(R.id.menu_screen);
        LinearLayout.LayoutParams layout = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 65);
        LinearLayout menu_row = new LinearLayout(this);
        menu_row.setLayoutParams(layout);
        menu_row.setWeightSum(2);

        menu_screen.addView(menu_row);

        TextView menu_item = new TextView(this);
        menu_item.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT, 1));
        menu_item.setGravity(11);
        menu_item.setTextSize(15);
        menu_item.setText("Burger");
        menu_row.addView(menu_item);

        TextView menu_price = new TextView(this);
        menu_price.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT, 1));
        menu_price.setGravity(11);
        menu_price.setTextSize(15);
        menu_price.setText("R35");
        menu_row.addView(menu_price);





    }
}