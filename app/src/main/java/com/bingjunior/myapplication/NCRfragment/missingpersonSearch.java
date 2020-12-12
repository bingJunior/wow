package com.bingjunior.myapplication.NCRfragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.bingjunior.myapplication.Fragment.layout_login;
import com.bingjunior.myapplication.R;

public class missingpersonSearch extends Fragment {
    private View v;
    private Button filter;
    private FrameLayout frameLayout;
    public missingpersonSearch() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        v=inflater.inflate(R.layout.missingpersonsearch,container,false);
        filter=v.findViewById(R.id.filter_missing_person_search);

       frameLayout=getActivity().findViewById(R.id.frameid);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setFragment(new filterMissingPersonSearch());
            }
        });
    }

    private void setFragment(filterMissingPersonSearch filterMissingPersonSearch) {
        FragmentTransaction fragmentTransaction=getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(frameLayout.getId(),filterMissingPersonSearch);
        fragmentTransaction.commit();
    }

}

