package com.example.finaldemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import androidx.cardview.widget.CardView;
import androidx.appcompat.app.AppCompatActivity;

public class VendorSelection extends AppCompatActivity {

    String person_number;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vendor_card);

        VendorController vendCont = new VendorController(this);
        Intent intent = getIntent();
        person_number = intent.getStringExtra("username");

        if(!vendCont.vendorLogin("Budget Rolls")) {
            vendCont.vendorSignUp("Budget Rolls", "", "", "Upper Campus", 0, "", "9 - 5");
        }
        if(!vendCont.vendorLogin("Varsity Fast Food")) {
            vendCont.vendorSignUp("Varsity Fast Food", "", "", "", 0, "", "");
        }
        if(!vendCont.vendorLogin("Best Quality")) {
            vendCont.vendorSignUp("Best Quality", "", "", "", 0, "", "");
        }
        if(!vendCont.vendorLogin("Afriquezeen")) {
            vendCont.vendorSignUp("Afriquezeen", "", "", "", 0, "", "");
        }
        if(!vendCont.vendorLogin("Dans Health Shop")) {
            vendCont.vendorSignUp("Dans Health Shop", "", "", "", 0, "", "");
        }
        if(!vendCont.vendorLogin("Campus Cafe")) {
            vendCont.vendorSignUp("Campus Cafe", "", "", "", 0, "", "");
        }
        if(!vendCont.vendorLogin("Prashad")) {
            vendCont.vendorSignUp("Prashad", "", "", "", 0, "", "");
        }

    }

    public void budgetRollsHandler(View v){
        Intent intent = new Intent(v.getContext(), MainOptions.class);
        intent.putExtra("vendor_name", "Budget Rolls");
        intent.putExtra("username", person_number);
        v.getContext().startActivity(intent);
    }

    public void varsityHandler(View v){
        Intent intent = new Intent(v.getContext(), MainOptions.class);
        intent.putExtra("vendor_name", "Varsity Fast Food");
        intent.putExtra("username", person_number);
        v.getContext().startActivity(intent);
    }

    public void bestQualityHandler(View v){
        Intent intent = new Intent(v.getContext(), MainOptions.class);
        intent.putExtra("vendor_name", "Best Quality");
        intent.putExtra("username", person_number);
        v.getContext().startActivity(intent);
    }

    public void afriquezeenHandler(View v){
        Intent intent = new Intent(v.getContext(), MainOptions.class);
        intent.putExtra("vendor_name", "Afriquezeen");
        intent.putExtra("username", person_number);
        v.getContext().startActivity(intent);
    }

    public void dansshop(View v){
        Intent intent = new Intent(v.getContext(), MainOptions.class);
        intent.putExtra("vendor_name", "Dan's Health Shop");
        intent.putExtra("username", person_number);
        v.getContext().startActivity(intent);
    }

    public void campusCafeHandler(View v){
        Intent intent = new Intent(v.getContext(), MainOptions.class);
        intent.putExtra("vendor_name", "Campus Cafe");
        intent.putExtra("username", person_number);
        v.getContext().startActivity(intent);
    }

    public void prashadHandler(View v){
        Intent intent = new Intent(v.getContext(), MainOptions.class);
        intent.putExtra("vendor_name", "Prashad");
        intent.putExtra("username", person_number);
        v.getContext().startActivity(intent);
    }
}
