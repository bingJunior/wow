package com.bingjunior.myapplication.NCR_REGISTER;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.bingjunior.myapplication.NCRfragment.missingchildrenSearch;
import com.bingjunior.myapplication.NCRfragment.missingpersonSearch;
import com.bingjunior.myapplication.R;

public class MissingChildrenSearch extends AppCompatActivity {
private FrameLayout frameLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_missing_children_search);

        frameLayout=findViewById(R.id.frameid);

        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction ft=fragmentManager.beginTransaction();
        ft.replace(R.id.frameid,new missingchildrenSearch());
        ft.commit();
    }
}