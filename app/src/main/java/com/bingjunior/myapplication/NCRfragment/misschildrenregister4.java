package com.bingjunior.myapplication.NCRfragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.bingjunior.myapplication.R;
public class misschildrenregister4  extends Fragment {

    private View v;
    private Button finish;
    public misschildrenregister4() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        v=inflater.inflate(R.layout.fir_missing_children_register4,container,false);
        finish=v.findViewById(R.id.incidentnext);
        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),"finsih the form",Toast.LENGTH_SHORT).show();
            }
        });
        return v;
    }

}
