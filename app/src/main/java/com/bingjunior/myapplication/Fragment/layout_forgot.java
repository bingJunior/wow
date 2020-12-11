package com.bingjunior.myapplication.Fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.student.crimnalalert.R;

public class layout_forgot extends Fragment {
    View v;
    private EditText Email;
    private Button ResetButton;
    private TextView GoBack;
    private FrameLayout frameLayout;
    private LinearLayout linearLayout;

    private FirebaseAuth firebaseAuth;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v=inflater.inflate(R.layout.fragment_layout_forgot,container,false);
        Email=v.findViewById(R.id.et_emailaddress);
        ResetButton=v.findViewById(R.id.btn_reset_forgot);
        GoBack=v.findViewById(R.id.tv_go_back);
        linearLayout=v.findViewById(R.id.forgot_password_emailid_container);

        frameLayout=getActivity().findViewById(R.id.mainframeid);

        firebaseAuth= FirebaseAuth.getInstance();

        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                checkinputs();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        GoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setfragment(new layout_login());
            }
        });

        ResetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ResetButton.setEnabled(false);
                ResetButton.setTextColor(Color.argb(50,255,255,255));

                firebaseAuth.sendPasswordResetEmail(Email.getText().toString())
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {

                                if(task.isSuccessful()){
                                    Email.setText("");
                                    Toast.makeText(getActivity(), "email send sucessfully", Toast.LENGTH_SHORT).show();
                                }else {
                                    String error=task.getException().getMessage();
                                    Toast.makeText(getActivity(), ""+error, Toast.LENGTH_SHORT).show();
                                }
                                ResetButton.setEnabled(true);
                                ResetButton.setTextColor(Color.rgb(255,255,255));
                            }
                        });
            }
        });
    }

    private void checkinputs() {
        if(TextUtils.isEmpty(Email.getText().toString())){
           ResetButton.setEnabled(false);
           ResetButton.setTextColor(Color.argb(50,255,255,255));
        }else{
            ResetButton.setEnabled(true);
            ResetButton.setTextColor(Color.rgb(255,255,255));
        }
    }

    private void setfragment(Fragment fragment) {

        FragmentTransaction fragmentTransaction=getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(frameLayout.getId(),fragment);
        fragmentTransaction.commit();

    }
}