package com.example.finaldemo;

import android.content.Context;

public class VendorController {

    VendorModel vendor ;
    MenuModel menu;

    public VendorController(Context context){

        vendor = new VendorModel(context);
        menu = new MenuModel();
    }

    public boolean vendorLogin(String vendor_name){
        return vendor.checkIfVendorExists(vendor_name);
    }

    public String populateVendorAcc(String vendor_name){
        return vendor.getVendor(vendor_name).toString();
    }

    public String getVendorLocation(String vendor_name){
        return vendor.getVendor(vendor_name).get(3);
    }

    public String getVendorTimes(String vendor_name){
        return vendor.getVendor(vendor_name).get(6);
    }

    public void vendorSignUp(String vendor_name, String password, String qr_string, String location, int rating, String contact_details, String operating_times){
        vendor.addNewVendor(vendor_name,password,qr_string, location, rating, contact_details, operating_times);
    }



}
