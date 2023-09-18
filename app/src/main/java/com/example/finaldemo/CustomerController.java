package com.example.finaldemo;

import android.content.Context;
import android.media.Image;
import android.util.Log;

public class CustomerController {

    CustomerModel customer;
    VendorModel vendor;

    ReviewModel review;
    public CustomerController(Context context){
        customer = new CustomerModel(context);
        vendor = new VendorModel(context);
        review = new ReviewModel();
    }

    public boolean customerLogin(String username,  String password){
        Log.i("username_check", username);
        return customer.checkIfCustomerExists(username);

    }

    public String updateCustomerAcc(String user){
        return customer.getCustomer(user).toString();
    }

    public void customerSignup(String username, String password, int points, String name, String surname, String email){
        customer.addNewCustomer(username, password,0, name, surname, email);
    }

    public void scanQR(Image image){
        // convert image QR
    }

}
