package com.bingjunior.myapplication.NCRfragment;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.bingjunior.myapplication.Modal.Skel_MissingPersonForm;
import com.bingjunior.myapplication.R;

import java.util.Calendar;

import static java.lang.String.valueOf;

public class misspersonregister1  extends Fragment implements AdapterView.OnItemSelectedListener {

    private View v;
    private Button firstnext;

    public misspersonregister1() {
    }
    private EditText fullname,fathername,address,yearofbirth,weigth;
     EditText age,heightfromfeet,heightfrominch,heightfromcm, heighttofeet,heighttoinch,heighttocm;
    private Spinner relation,gender,complexion;
    private String Relation[]={"select none","Father","Mother","Sister","brother","Husband","Wife"};
    private String Complexion[]={"select none","Light Skin","Fair Skin","Medium Skin","Oliv Skin","Tanbrown Skin","Blackbrown Skin"};
    private String Gender[]={"select none","Male","Female","others"};
    private Double totalheightfromCM,totalheightToCM;
    private static String spinrelation, spingender,spincomplexion;

    String DOB_pattern = "^(1[0-2]|0[1-9])/(3[01]"
            + "|[12][0-9]|0[1-9])/[0-9]{4}$";
    //private String DOB_pattern="^[0-3]?[0-9]/[0-3]?[0-9]/(?:[0-9]{2})?[0-9]{2}$" ;


    private DatePickerDialog.OnDateSetListener dd=new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int year, int month, int day) {
            yearofbirth.setText(day+" / "+(month+1)+" / "+year);
        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        v=inflater.inflate(R.layout.fir_miss_person_register1,container,false);

        firstnext=v.findViewById(R.id.firstnext);

        fullname=v.findViewById(R.id.MDPreg1fullname);
        fathername=v.findViewById(R.id.MDPreg1fathername);
        address=v.findViewById(R.id.MDPreg1address);
        yearofbirth=v.findViewById(R.id.MDPreg1yearofbirth);
        weigth=v.findViewById(R.id.MDPreg1weight);

        // private EditText agefrom,ageto,heightfromfeet,heightfrominch,heightfromcm, heighttofeet,heighttoinch,heighttocm;
        age=v.findViewById(R.id.age);
        heightfromfeet=v.findViewById(R.id.MDPreg1heightfromfeet);
        heightfrominch=v.findViewById(R.id.MDPreg1heightfrominch);
        heightfromcm=v.findViewById(R.id.MDPreg1heightfromcm);
        heighttofeet=v.findViewById(R.id.MDPreg1heighttofeet);
        heighttoinch=v.findViewById(R.id.MDPreg1heighttoinch);
        heighttocm=v.findViewById(R.id.MDPreg1heighttocm);
        //assign spinner id
        relation=v.findViewById(R.id.spinnerrelation);
        gender=v.findViewById(R.id.spinnergender);
        complexion=v.findViewById(R.id.spinnercomplexion);

        relation.setOnItemSelectedListener(this);
        gender.setOnItemSelectedListener(this);
        complexion.setOnItemSelectedListener(this);

       ArrayAdapter relationadapter=new ArrayAdapter(getContext(),android.R.layout.simple_spinner_item,Relation);
        relationadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        relation.setAdapter(relationadapter);

      ArrayAdapter genderadapter=new ArrayAdapter(getContext(),android.R.layout.simple_spinner_item,Gender);
        genderadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        gender.setAdapter(genderadapter);

       ArrayAdapter complexionadapter=new ArrayAdapter(getContext(),android.R.layout.simple_spinner_item,Complexion);
        complexionadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        complexion.setAdapter(complexionadapter);

        fullname.addTextChangedListener(new TextWatcher() {
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
        address.addTextChangedListener(new TextWatcher() {
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
        yearofbirth.addTextChangedListener(new TextWatcher() {
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
        weigth.addTextChangedListener(new TextWatcher() {
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

        age.addTextChangedListener(new TextWatcher() {
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
        heightfromfeet.addTextChangedListener(new TextWatcher() {
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
        heightfrominch.addTextChangedListener(new TextWatcher() {
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
        heightfromcm.addTextChangedListener(new TextWatcher() {
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
        heighttofeet.addTextChangedListener(new TextWatcher() {
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
        heighttoinch.addTextChangedListener(new TextWatcher() {
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
        heighttocm.addTextChangedListener(new TextWatcher() {
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

        firstnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkvalidation();
                Skel_MissingPersonForm MissingPersonFormInstance = Skel_MissingPersonForm.getInstance();
                MissingPersonFormInstance.setName(fullname.getText().toString());
                MissingPersonFormInstance.setAddress(address.getText().toString());
                MissingPersonFormInstance.setFathername(fathername.getText().toString());
                MissingPersonFormInstance.setRelation(spinrelation);
                MissingPersonFormInstance.setGender(spingender);
                MissingPersonFormInstance.setDOB(yearofbirth.getText().toString());
                MissingPersonFormInstance.setAge(age.getText().toString());
                MissingPersonFormInstance.setHeightfrom(String.valueOf(totalheightfromCM));
                MissingPersonFormInstance.setHeightto(String.valueOf(totalheightToCM));
                MissingPersonFormInstance.setWeight(weigth.getText().toString());
                MissingPersonFormInstance.setComplexion(spincomplexion);

                FragmentManager fragmentManager=getFragmentManager();
                FragmentTransaction ft=fragmentManager.beginTransaction();
                ft.replace(R.id.ncrframe,new misspersonregister2());
                ft.commit();
            }
        });
        yearofbirth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar=Calendar.getInstance();
                new DatePickerDialog(getContext(),dd,calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        

        return v;
    }


    private void checkvalidation() {
           Drawable erroricon=getResources().getDrawable(R.mipmap.error);
           erroricon.setBounds(0,0,erroricon.getIntrinsicWidth(),erroricon.getIntrinsicHeight());

           Integer h1= Integer.valueOf(heightfromfeet.getText().toString());
           Integer h2= Integer.valueOf(heightfrominch.getText().toString());
           Integer h3= Integer.valueOf(heightfromcm.getText().toString());

           Integer H1= Integer.valueOf(heightfromfeet.getText().toString());
           Integer H2= Integer.valueOf(heightfrominch.getText().toString());
           Integer H3= Integer.valueOf(heightfromcm.getText().toString());

            totalheightfromCM= ( h1* 3.038E01) + (h2 * 2.54) + h3;
           Log.e("total height in cm", String.valueOf(totalheightfromCM));
            totalheightToCM= ( h1* 3.038E01) + (h2 * 2.54) + h3;
           Log.e("total height in cm", String.valueOf(totalheightToCM));

        if(yearofbirth.getText().toString().matches(DOB_pattern)){
            Log.e("pattern correct","go with correct pattern");
        }
        else {
            Log.e("pattern doonot","go  pattern");
            yearofbirth.setError("Invalid Pattern of Date Of Birth should be dd/mm/yyyy !!!!",erroricon);
        }


    }

    private void checkInputs() {
        if(!TextUtils.isEmpty(fullname.getText())) {
            if(!TextUtils.isEmpty(address.getText())){
                if(!TextUtils.isEmpty(yearofbirth.getText())){
                    if(!TextUtils.isEmpty(weigth.getText())){
                        if(!TextUtils.isEmpty(heightfromfeet.getText())){
                            if(!TextUtils.isEmpty(heightfrominch.getText())){
                                if(!TextUtils.isEmpty(heightfromcm.getText())){
                                    if(!TextUtils.isEmpty(heighttofeet.getText())){
                                        if(!TextUtils.isEmpty(heighttoinch.getText())){
                                            if(!TextUtils.isEmpty(heighttocm.getText())){
                                                if(!spinrelation.equalsIgnoreCase("select none")){
                                                    Toast.makeText(getContext(),spinrelation,Toast.LENGTH_SHORT).show();
                                                    firstnext.setEnabled(true);
                                                    firstnext.setTextColor(Color.rgb(255,255,255));
                                                }
                                                else{
                                                    firstnext.setEnabled(false);
                                                    firstnext.setTextColor(Color.argb(50,255,255,255));
                                                }
//
                                            }
                                            else{
                                                firstnext.setEnabled(false);
                                                firstnext.setTextColor(Color.argb(50,255,255,255));
                                            }
                                        }
                                        else{
                                            firstnext.setEnabled(false);
                                            firstnext.setTextColor(Color.argb(50,255,255,255));
                                        }

                                    }else{
                                        firstnext.setEnabled(false);
                                        firstnext.setTextColor(Color.argb(50,255,255,255));

                                    }

                                }else{
                                    firstnext.setEnabled(false);
                                    firstnext.setTextColor(Color.argb(50,255,255,255));
                                }

                            }else{
                                firstnext.setEnabled(false);
                                firstnext.setTextColor(Color.argb(50,255,255,255));
                            }

                        }else{
                            firstnext.setEnabled(false);
                            firstnext.setTextColor(Color.argb(50,255,255,255));
                        }

                    }else{
                        firstnext.setEnabled(false);
                        firstnext.setTextColor(Color.argb(50,255,255,255));
                    }

                }else{
                    firstnext.setEnabled(false);
                    firstnext.setTextColor(Color.argb(50,255,255,255));
                }
            }else{
                firstnext.setEnabled(false);
                firstnext.setTextColor(Color.argb(50,255,255,255));
            }
        }
        else{
            firstnext.setEnabled(false);
            firstnext.setTextColor(Color.argb(50,255,255,255));
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

      //  String spinrelation=relation.getSelectedItem().toString();

         spingender=gender.getSelectedItem().toString();
         spincomplexion=complexion.getSelectedItem().toString();

         spinrelation=relation.getItemAtPosition(i).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
