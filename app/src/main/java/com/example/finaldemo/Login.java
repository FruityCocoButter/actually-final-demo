package com.example.finaldemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        /**
        Button login_button = (Button) findViewById(R.id.login_button);


        EditText username = (EditText) findViewById(R.id.username_field);
        EditText pass_word = (EditText) findViewById(R.id.password_field);
        String person_number = username.getText().toString();
        String password = pass_word.getText().toString();

        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CustomerController cust = new CustomerController(view.getContext());
                Log.i("tracer", person_number);
                Log.i("what is happening", String.valueOf(cust.customerLogin(person_number, password)));

                if (!cust.customerLogin(person_number, password)){
                     if customer not signed up, sign up
                    Intent intent = new Intent(view.getContext(), SignUp.class);
                    view.getContext().startActivity(intent);

                }

                else{
                    move to next screen
                }
            }
        });
        **/

    }

    public void loginButtonHandler(View view){
        EditText username = (EditText) findViewById(R.id.username_field);
        EditText pass_word = (EditText) findViewById(R.id.password_field);
        String person_number = username.getText().toString();
        String password = pass_word.getText().toString();

        CustomerController cust = new CustomerController(view.getContext());
        Log.i("tracer", person_number);
        Log.i("what is happening", String.valueOf(cust.customerLogin(person_number, password)));

        if (!cust.customerLogin(person_number, password)){
            /** if customer not signed up, sign up**/
            Intent intent = new Intent(view.getContext(), SignUp.class);
            view.getContext().startActivity(intent);

        }

        else{
            /**move to next screen**/
            Intent intent = new Intent(view.getContext(),VendorSelection.class);
            intent.putExtra("username", person_number);
            view.getContext().startActivity(intent);
        }




    }

    public void signUpButtonHandler(View view){
        Intent intent = new Intent(this, SignUp.class);
        this.startActivity(intent);
    }




}