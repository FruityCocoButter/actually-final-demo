package com.example.finaldemo;

import android.content.Context;
import android.media.Image;

public class CustomerController {

    CustomerModel customer;
    VendorModel vendor;

    ReviewModel review;
    public CustomerController(Database db){
        customer = new CustomerModel(db);
        vendor = new VendorModel(db);
        review = new ReviewModel(db);
    }

    public boolean customerLogin(String username,  String password){

        return customer.checkIfCustomerExists(username);

    }

    public String updateCustomerAcc(String user){
        return customer.getCustomer(user).toString();
    }

    public void customerSignup(String username, String password, int points){
        customer.addNewCustomer(username, password,0);
    }

    public void scanQR(Image image){
        // convert image QR
    }

    public void reviewVendor(int rev_num, String username,String vendor, int clean, int eff,
                             int food, String comm){

        review.addNewReview(1,username,vendor,clean,eff,food,comm);

        earnPoints(5);
    }

    public void earnPoints(int points){
        // assign_points
    }
}
