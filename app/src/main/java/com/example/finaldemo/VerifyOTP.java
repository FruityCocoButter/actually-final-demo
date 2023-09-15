package com.example.finaldemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

public class VerifyOTP extends AppCompatActivity {

    public String verificationID ;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.verifyotp);

        EditText input = findViewById(R.id.editTextNumberV);

        final Button button = findViewById(R.id.buttonVerify);

        TextView textMobile = findViewById(R.id.textmobile);
        textMobile.setText(String.format("+27-%s",getIntent().getStringExtra("mobile")));

        verificationID = getIntent().getStringExtra("verificationID");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (input.getText().toString().trim().isEmpty()){
                    Toast.makeText(VerifyOTP.this,"Please enter valid code",Toast.LENGTH_SHORT).show();
                    return;

                }

                String code = input.getText().toString();

                if (verificationID != null){
                    PhoneAuthCredential phoneAuthCredential = PhoneAuthProvider.getCredential(
                            verificationID,
                            code
                    );
                    FirebaseAuth.getInstance().signInWithCredential(phoneAuthCredential)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()){
                                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                        startActivity(intent);

                                    }
                                    else {
                                        Toast.makeText(VerifyOTP.this,"failed",Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });

                }
            }
        });

    }
}
