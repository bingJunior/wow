package com.bingjunior.myapplication.Fragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.bingjunior.myapplication.R;
import com.bingjunior.myapplication.viewfeatures;

public class layout_PREMIUM extends Fragment {

    View v,v1;
    Button getpremium,viewfeatures;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        v=inflater.inflate(R.layout.activity_layout__p_r_e_m_i_u_m,container,false);
        getpremium=v.findViewById(R.id.getpremium);
        viewfeatures=v.findViewById(R.id.viewfeatures);

        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getpremium.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View view) {

                LayoutInflater inflater=LayoutInflater.from(getContext());
                v1=inflater.inflate(R.layout.get_premium,null);
                AlertDialog.Builder alertDialog= new AlertDialog.Builder(getContext());
                     alertDialog.setView(v1);
                      alertDialog  .create();
                alertDialog.show();

            }
        });

        viewfeatures.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(),viewfeatures.class);
                startActivity(intent);
            }
        });
    }


}