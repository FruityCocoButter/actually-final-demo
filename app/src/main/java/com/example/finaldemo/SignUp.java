package com.example.finaldemo;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        /***
        Button submit_button = (Button) findViewById(R.id.submit_button);




        EditText username = findViewById(R.id.username_input);
        EditText name_in = findViewById(R.id.name_input);
        EditText surname_in = findViewById(R.id.surname_input);
        EditText email_in = findViewById(R.id.email_input);
        EditText pass_word = findViewById(R.id.password_input);
        EditText confirm_pass = findViewById(R.id.confirm_pass_input);

        String person_number = username.getText().toString();
        String name = name_in.getText().toString();
        String surname = surname_in.getText().toString();
        String email = email_in.getText().toString();
        String password = pass_word.getText().toString();
        String confirmation = confirm_pass.getText().toString();

        SignUp this_class = this;

        submit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("tracing", "is this ever called");
                CustomerController cust = new CustomerController(v.getContext());
                Log.i("loginfeature", String.valueOf(cust.customerLogin(person_number, password)));
                if (!cust.customerLogin(person_number, password)){
                    move to next screen
                    cust.customerSignup(person_number, password, 0, name, surname, email);
                    Intent intent = new Intent(v.getContext(), SendOTP.class);
                    v.getContext().startActivity(intent);
                }


            }
        });**/
    }

    public void signUpHandle(View view){
        String password = "0";
        String confirmation = "1";


        EditText username = findViewById(R.id.username_input);
        EditText name_in = findViewById(R.id.name_input);
        EditText surname_in = findViewById(R.id.surname_input);
        EditText email_in = findViewById(R.id.email_input);
        EditText pass_word = findViewById(R.id.password_input);
        EditText confirm_pass = findViewById(R.id.confirm_pass_input);

        String person_number = username.getText().toString();
        String name = name_in.getText().toString();
        String surname = surname_in.getText().toString();
        String email = email_in.getText().toString();
        password = pass_word.getText().toString();
        confirmation = confirm_pass.getText().toString();
        /**
        if(!password.equals(confirmation)){
            signUpHandle(view);
        }**/


        CustomerController cust = new CustomerController(view.getContext());
        Log.i("loginfeature", String.valueOf(cust.customerLogin(person_number, password)));

        if (!cust.customerLogin(person_number, password)){
            /**move to next screen**/
            cust.customerSignup(person_number, password, 0, name, surname, email);
            Intent intent = new Intent(view.getContext(), SendOTP.class);
            view.getContext().startActivity(intent);
        }


        else{
             /**if customer signed up, log in**/
             try{
                 Thread.sleep(20000);
             }catch(InterruptedException ex){

             }
        }

    }
}
