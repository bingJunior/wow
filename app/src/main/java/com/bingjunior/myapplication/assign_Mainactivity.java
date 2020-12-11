package com.bingjunior.myapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class assign_Mainactivity extends AppCompatActivity {
    TextInputEditText name,email,password,mobilenumber;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainactivity);
        name=findViewById(R.id.username);
        email=findViewById(R.id.useremail);
        password=findViewById(R.id.userpassword);
        mobilenumber=findViewById(R.id.usermobilenumber);

        showdata();
    }

    private void showdata() {

        Intent intent=getIntent();

        String username=intent.getStringExtra("name");
        String useremail=intent.getStringExtra("email");
        String userpassword=intent.getStringExtra("password");
        String usermobile=intent.getStringExtra("phone");

        name.setText(username);
        email.setText(useremail);
        password.setText(userpassword);
        mobilenumber.setText(usermobile);
    }
}
