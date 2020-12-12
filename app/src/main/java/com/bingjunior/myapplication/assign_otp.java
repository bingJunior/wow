package com.bingjunior.myapplication;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bingjunior.myapplication.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class assign_otp extends AppCompatActivity {
    EditText number, otp;
    Button generateotp;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assign_otp);
        number = findViewById(R.id.number);
        otp = findViewById(R.id.otp);
        generateotp = findViewById(R.id.generateotp);

        mAuth = FirebaseAuth.getInstance();

        generateotp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mobile = number.getText().toString();
                sendVerificationCode(mobile);
            }
        });

//        generateotp.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                PhoneAuthProvider.getInstance().verifyPhoneNumber(
//                       "+91"+number,        // Phone number to verify
//                        60,                 // Timeout duration
//                        TimeUnit.SECONDS,   // Unit of timeout
//                        TaskExecutors.MAIN_THREAD,     // Activity (for callback binding)
//                        mCallbacks);        // OnVerificationStateChangedCallbacks
//
//            }
//        });
//         mCallbacks=new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
//
//             //different device
//             @Override
//             public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
//                 super.onCodeSent(s, forceResendingToken);
//
//                 verificationcodebysystem=s;
//             }
//
//             //same device
//             @Override
//             public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
//                 String code=phoneAuthCredential.getSmsCode();
//                 if(code!=null){
//                     verify.setEnabled(true);
//                     verifycode(code);
//                 }
//
//             }
//
//             @Override
//             public void onVerificationFailed(@NonNull FirebaseException e) {
//
//                 Toast.makeText(assign_otp.this,""+e.getMessage(),Toast.LENGTH_SHORT).show();
//             }
//         };


    }

    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
        @Override
        public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
            //Getting the code sent by SMS
            String code = phoneAuthCredential.getSmsCode();
            if (code != null) {

                verifyVerificationCode(code);
            }
        }

        @Override
        public void onVerificationFailed(FirebaseException e) {
            Toast.makeText(assign_otp.this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    };

    private void verifyVerificationCode(String code) {
        String mycode=otp.getText().toString();
        if (mycode.equals(code))
        {
            Toast.makeText(this, "verify", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "Not", Toast.LENGTH_SHORT).show();
        }
    }
    private void sendVerificationCode(String mobile) {
                PhoneAuthProvider.getInstance().verifyPhoneNumber(
                mobile,
                60,
                TimeUnit.SECONDS,
                TaskExecutors.MAIN_THREAD,
                mCallbacks);
    }

}
