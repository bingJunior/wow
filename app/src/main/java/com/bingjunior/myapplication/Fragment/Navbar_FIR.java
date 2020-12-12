package com.bingjunior.myapplication.Fragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bingjunior.myapplication.NavbarFirAdapter;
import com.bingjunior.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class Navbar_FIR extends Fragment {

   private View v;
   public Navbar_FIR() {
    }

    RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        v=inflater.inflate(R.layout.activity_navbar__f_i_r,container,false);

         recyclerView=v.findViewById(R.id.firRegister_id);


        NavbarFirAdapter obj=new NavbarFirAdapter();
        GridLayoutManager gridLayoutManager=new GridLayoutManager(v.getContext(),2,GridLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(obj);


        return v;
    }

}