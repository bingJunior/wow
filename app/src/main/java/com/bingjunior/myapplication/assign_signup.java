package com.bingjunior.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.api.Context;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

public class assign_signup extends AppCompatActivity {
    EditText name,phone,email,address,password;
    Button signin,read;
    FirebaseDatabase firebaseDatabase;
    private DatabaseReference reference1;
    assign_userdatabasehelper helper;
    TextView gologin;

    RecyclerView recyclerView;
    RecyclerView.LayoutManager manager;
    Context context;
    ArrayList<assign_userdatabasehelper> emailarray=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assign_signup);

        name=findViewById(R.id.etname);
        phone=findViewById(R.id.etphone);
        email=findViewById(R.id.etemail);
        address=findViewById(R.id.etaddress);
        password=findViewById(R.id.etpasswrd);
        signin=findViewById(R.id.btnsignin);
        read=findViewById(R.id.btnread);
        gologin=findViewById(R.id.go_login);

        recyclerView=findViewById(R.id.recycler);
        manager=new LinearLayoutManager(com.student.crimnalalert.assign_signup.this, RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(manager);


        firebaseDatabase=FirebaseDatabase.getInstance();
        reference1= firebaseDatabase.getReference("AssignmentUserData");

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enterdatainfirebase();
            }
        });
        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                readdatainfirebase();
            }
        });

        gologin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(com.student.crimnalalert.assign_signup.this,assign_login.class);
                startActivity(intent);
                finish();
            }
        });


    }

    private void readdatainfirebase() {

        reference1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Log.e("data",""+dataSnapshot);
                for(DataSnapshot data: dataSnapshot.getChildren()){
                    HashMap<String,Object> as=new HashMap<>();
                    as= (HashMap<String, Object>) data.getValue();
                    Log.e("username", String.valueOf(as.get("name")));
                    Log.e("Password", String.valueOf(as.get("password")));

                     helper=new assign_userdatabasehelper();

                    helper.setEmail(""+as.get("email"));
                    helper.setPassword(""+as.get("password"));

                    emailarray.add(helper);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        assign_adapter assign_adapter=new assign_adapter(com.student.crimnalalert.assign_signup.this,emailarray);
        recyclerView.setAdapter(assign_adapter);

    }

    private void enterdatainfirebase() {
        assign_userdatabasehelper assign_userdatabasehelper=new assign_userdatabasehelper(name.getText().toString(),
                phone.getText().toString(),email.getText().toString(),address.getText().toString(),
                password.getText().toString());
        //generate unique key
        String uniqueKey = reference1.child("AssignmentUserData").push().getKey();
        reference1.child(uniqueKey).setValue(assign_userdatabasehelper);
    }
}