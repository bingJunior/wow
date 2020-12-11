package com.bingjunior.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Splash_screen extends AppCompatActivity {
    FirebaseAuth firebaseAuth;
    FirebaseUser currentuser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        firebaseAuth= FirebaseAuth.getInstance();

        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent registerintent=new Intent(com.student.crimnalalert.Splash_screen.this,Registeractivity.class);
                startActivity(registerintent);
                finish();

//                currentuser=firebaseAuth.getCurrentUser();
//                if(currentuser==null){
//                    Intent registerintent=new Intent(Splash_screen.this,Registeractivity.class);
//                    startActivity(registerintent);
//                    finish();
//                }
//                else {
//                    Log.e("message", String.valueOf(currentuser));
//                    Intent MainIntent=new Intent(Splash_screen.this,MainActivity.class);
//                    startActivity(MainIntent);
//                    finish();
//                }
            }
        },3000);
    }

}