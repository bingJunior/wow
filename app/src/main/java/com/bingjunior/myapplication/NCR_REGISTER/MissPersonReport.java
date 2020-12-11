package com.student.crimnalalert.NCR_REGISTER;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.student.crimnalalert.NCRfragment.misspersonregister1;
import com.student.crimnalalert.R;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Build;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;

public class MissPersonReport extends AppCompatActivity{
    private FrameLayout ncrframe;
    private Button next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_miss_person_report);

        if (Build.VERSION.SDK_INT >= 19) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        } else {
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        }

        ncrframe=findViewById(R.id.ncrframe);

        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction ft=fragmentManager.beginTransaction();
        ft.replace(R.id.ncrframe,new misspersonregister1());
        ft.commit();

    }

}
