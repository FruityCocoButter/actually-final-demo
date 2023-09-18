package com.example.finaldemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.widget.TextView;

public class VendorInfo extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vendor_info);

        Intent intent = getIntent();
        String vendor_name = intent.getStringExtra("vendor_name");

        TextView vendor_name_text = findViewById(R.id.vendor_name_text);
        TextView operating_times = findViewById(R.id.operating_times);
        TextView address = findViewById(R.id.address);

        vendor_name_text.setText(vendor_name);

        VendorController vendCont = new VendorController(this);
        operating_times.setText(vendCont.getVendorTimes(vendor_name));
        address.setText(vendCont.getVendorLocation(vendor_name));

        String vendor_info =vendCont.populateVendorAcc(vendor_name);
        Log.i("vend_info", vendor_info);


    }
}
