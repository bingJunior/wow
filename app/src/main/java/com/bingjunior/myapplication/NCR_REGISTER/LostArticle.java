package com.student.crimnalalert.NCR_REGISTER;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.student.crimnalalert.NCRfragment.lostarticle;
import com.student.crimnalalert.NCRfragment.misspersonregister1;
import com.student.crimnalalert.R;

public class LostArticle extends AppCompatActivity {
 private FrameLayout frameLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lost_article);

        frameLayout=findViewById(R.id.frameid);

        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction ft=fragmentManager.beginTransaction();
        ft.replace(R.id.frameid,new lostarticle());
        ft.commit();
    }
}