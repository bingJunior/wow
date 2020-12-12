package com.bingjunior.myapplication.Fragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.bingjunior.myapplication.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class layout_GUIDE extends Fragment {

    View v;
    ExpandableListView expandableListView;
    List<String> listGroup;
    HashMap<String,List<String>>listItem;
    com.bingjunior.myapplication.Fragment.MainAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        v=inflater.inflate(R.layout.activity_layout__g_u_i_d_e,container,false);
        expandableListView=v.findViewById(R.id.expandableView);
        listGroup=new ArrayList<>();
        listItem=new HashMap<>();
        adapter=new com.bingjunior.myapplication.Fragment.MainAdapter(v.getContext(),listGroup,listItem);
        expandableListView.setAdapter(adapter);
        initListView();
        return v;
    }

    private void initListView() {
        listGroup.add(getString(R.string.group1));
        listGroup.add(getString(R.string.group2));
        listGroup.add(getString(R.string.group3));
        String[] array;
        List<String> L1=new ArrayList<>();
        array=getResources().getStringArray(R.array.group1);
        for(String item:array)
        {
            L1.add(item);
        }
        List<String> L2=new ArrayList<>();
        array=getResources().getStringArray(R.array.group2);
        for(String item:array)
        {
            L2.add(item);
        }
        List<String> L3=new ArrayList<>();
        array=getResources().getStringArray(R.array.group3);
        for(String item:array)
        {
            L3.add(item);
        }
        listItem.put(listGroup.get(0),L1);
        listItem.put(listGroup.get(1),L2);
        listItem.put(listGroup.get(2),L3);
        adapter.notifyDataSetChanged();
    }
}