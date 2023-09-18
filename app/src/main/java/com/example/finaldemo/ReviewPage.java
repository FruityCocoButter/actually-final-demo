package com.example.finaldemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ReviewPage extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.review_page);

        Intent intent = getIntent();
        String vendor_name = intent.getStringExtra("vendor_name");
        String username = intent.getStringExtra("username");

        /**make review here**/

        Button checkReward = findViewById(R.id.make_review);
        checkReward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), RewardPage.class);
                intent.putExtra("vendor_name", vendor_name);
                intent.putExtra("username", username);
                view.getContext().startActivity(intent);
            }
        });



    }
}
