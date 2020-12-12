package com.bingjunior.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bingjunior.myapplication.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Iterator;

public class assign_login extends AppCompatActivity {
    EditText email, password;
    Button login;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference root;
    TextView gosignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assign_login);

        email = findViewById(R.id.et_email);
        password = findViewById(R.id.et_password);
        login = findViewById(R.id.login);
        gosignup = findViewById(R.id.go_signup);
        root = FirebaseDatabase.getInstance().getReference("AssignmentUserData");

        gosignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(assign_login.this, com.bingjunior.myapplication.assign_signup.class);
                startActivity(intent);
                finish();
            }
        });
        login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
            root.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    for(DataSnapshot data:dataSnapshot.getChildren()){
                       String keys= data.getKey();
                       Log.e("keys",""+keys);

                        root.child(""+keys).addValueEventListener(new ValueEventListener() {

                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot2) {

                                String emailfromdb=dataSnapshot2.child("email").getValue(String.class);
                                String passwordfromdb=dataSnapshot2.child("password").getValue(String.class);
                //                                    Log.e("email",""+emailfromdb);
                //                                    Log.e("password",""+passwordfromdb);

                                if(email.getText().toString().equals(emailfromdb)&&password.getText().toString().equals(passwordfromdb)){
                                    Log.e("yess ","yess");
                                    Toast.makeText(assign_login.this, "Sucessfully", Toast.LENGTH_SHORT).show();
                                }
                                else{
                                    Log.e("email",""+emailfromdb);
                                    Log.e("password",""+passwordfromdb);

                                    Log.e("No ","No");
                                    Toast.makeText(assign_login.this, "try again", Toast.LENGTH_SHORT).show();
                                }
                            }
                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {
                                }
                         });
                     Log.e("yess ","checkkyess");
                    }
                }
                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });

            }
        });

    }
}

//        login.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                final String userenteredemail = email.getText().toString();
//                final String userenteredpassword = password.getText().toString();
//
//                firebaseDatabase = FirebaseDatabase.getInstance();
//                databaseReference = firebaseDatabase.getReference("AssignmentUserData");
//                //databaseReference=FirebaseDatabase.getInstance().getReference("AssignmentUserData");
//
//                Query checkuser = databaseReference.orderByChild("email").equalTo(userenteredemail);
//
//                checkuser.addListenerForSingleValueEvent(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                        if (dataSnapshot.exists()) {
//
//                            String passwordFromDb = dataSnapshot.child(userenteredemail).child("password").getValue(String.class);
//                            Log.e("tag", "" + passwordFromDb);
//                            if (passwordFromDb.equals(userenteredpassword)) {
//
//                                email.setError(null);
//
//                                String emailformdb = dataSnapshot.child(userenteredemail).child("email").getValue(String.class);
//                                String passwordformdb = dataSnapshot.child(userenteredemail).child("password").getValue(String.class);
//                                String namefromdb = dataSnapshot.child(userenteredemail).child("name").getValue(String.class);
//                                String mobilenumberfromdb = dataSnapshot.child(userenteredemail).child("mobilenumber").getValue(String.class);
//
//                                Intent intent = new Intent(assign_login.this, assign_Mainactivity.class);
//
//                                intent.putExtra("email", emailformdb);
//                                intent.putExtra("password", passwordformdb);
//                                intent.putExtra("name", namefromdb);
//                                intent.putExtra("mobilenumber", mobilenumberfromdb);
//                                startActivity(intent);
//                            } else {
//                                password.setError("wrong Password");
//
//                            }
//                        } else {
//                            email.setError("No such user exixtes");
//                        }
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError databaseError) {
//
//                    }
//                });
//
//            };
//
//
//        });


