package com.bingjunior.myapplication.NCRfragment;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.bingjunior.myapplication.Modal.Skel_MissingPersonForm;
import com.bingjunior.myapplication.R;

import java.util.Calendar;

public class misspersonregister2  extends Fragment {

    private View v;
    private Button next;
    private EditText incidenttime,incidentplace,incidentdetails,incidentdate;
    private TimePickerDialog.OnTimeSetListener dd1=new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker timePicker, int hours, int minute) {
            incidenttime.setText(hours+" : "+minute);
        }
    };

    private DatePickerDialog.OnDateSetListener dd=new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int year, int month, int day) {
            incidentdate.setText(day+" / "+(month+1)+" / "+year);
        }
    };
    public misspersonregister2() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        v=inflater.inflate(R.layout.fir_miss_person_register2,container,false);
        next=v.findViewById(R.id.incidentnext);
       // incidenttime,incidentplace,incidentdetails,incidentdate;
        incidentdetails=v.findViewById(R.id.incidentdetails);
        incidentplace=v.findViewById(R.id.incidentplace);
        incidentdate=v.findViewById(R.id.incidentdate);
        incidenttime=v.findViewById(R.id.incidenttime);

        incidentdetails.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                checkInputs();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        incidentplace.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                checkInputs();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        incidentdate.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                checkInputs();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        incidenttime.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                checkInputs();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Skel_MissingPersonForm MissingPersonFormInstance = Skel_MissingPersonForm.getInstance();

                MissingPersonFormInstance.setIncidentdate(incidentdate.getText().toString());
                MissingPersonFormInstance.setIncidenttime(incidenttime.getText().toString());
                MissingPersonFormInstance.setIncidentplace(incidentplace.getText().toString());
                MissingPersonFormInstance.setIncidentdetails(incidentdetails.getText().toString());


                FragmentManager fragmentManager=getFragmentManager();
                FragmentTransaction ft=fragmentManager.beginTransaction();
                ft.replace(R.id.ncrframe,new misspersonregister3());
                ft.commit();
            }
        });
        incidentdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar=Calendar.getInstance();
                new DatePickerDialog(getContext(),dd,calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        incidenttime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar time=Calendar.getInstance();
                new TimePickerDialog(getContext(),dd1,time.get(Calendar.HOUR),
                        time.get(Calendar.MINUTE),false).show();
            }
        });

        return v;
    }

    private void checkInputs() {
        if(!TextUtils.isEmpty(incidentdetails.getText())){
            if(!TextUtils.isEmpty(incidentplace.getText())){
                if(!TextUtils.isEmpty(incidentdate.getText())){
                    if(!TextUtils.isEmpty(incidenttime.getText())){
                        next.setEnabled(true);
                         next.setTextColor(Color.rgb(255,255,255));

                    }else {
                        next.setEnabled(false);
                        next.setTextColor(Color.argb(50,255,255,255));
                    }

                }else{
                    next.setEnabled(false);
                    next.setTextColor(Color.argb(50,255,255,255));
                }
            }
            else{
                next.setEnabled(false);
                next.setTextColor(Color.argb(50,255,255,255));
            }
        }
        else{
            next.setEnabled(false);
            next.setTextColor(Color.argb(50,255,255,255));
        }
    }

}
