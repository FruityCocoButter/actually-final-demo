package com.example.finaldemo;

public class VendorController {

    VendorModel vendor ;
    MenuModel menu;

    public VendorController(){

        vendor = new VendorModel();
        menu = new MenuModel();
    }

    public boolean vendorLogin(int vendor_num){
        return vendor.checkIfVendorExists(vendor_num);
    }

    public String populateVendorAcc(int vendor_num){
        return vendor.getVendor(vendor_num).toString();
    }

    public void vendorSignUp(String password, String qr_string, String location){
        vendor.addNewVendor(password,qr_string, location);
    }



}
