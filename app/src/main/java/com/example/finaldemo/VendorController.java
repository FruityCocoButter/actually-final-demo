package com.example.finaldemo;

public class VendorController {

    VendorModel vendor ;
    MenuModel menu;

    public VendorController(Database db){

        vendor = new VendorModel(db);
        menu = new MenuModel(db);
    }

    public boolean vendorLogin(int vendor_num){
        return vendor.checkIfVendorExists(vendor_num);
    }

    public String populateVendorAcc(String vendor_num){
        return vendor.getVendor(vendor_num).toString();
    }

    public void vendorSignUp(String ven_number, String password){
        vendor.addNewVendor(ven_number,password,"s");
    }



}
