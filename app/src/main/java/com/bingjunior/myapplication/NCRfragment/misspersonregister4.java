package com.bingjunior.myapplication.NCRfragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.bingjunior.myapplication.Modal.Skel_MissingPersonForm;
import com.bingjunior.myapplication.R;

import java.util.HashMap;
import java.util.Map;

import static com.bingjunior.myapplication.R.*;

public class misspersonregister4 extends Fragment implements AdapterView.OnItemSelectedListener {

    private View v;
    private EditText name,address,mobilenumber,landlinenumber,email,any_other_info;
    private Spinner Relation;
    private String[] RelationName ={"select none","Father","Mother","Sister","brother","Husband","Wife"};
    private Button finish;
    private String takerelation;
    private  String UID;
    FirebaseFirestore db;
    FirebaseAuth auth;
    Skel_MissingPersonForm MissingPersonFormInstance;


    public misspersonregister4() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        v=inflater.inflate(layout.fir_miss_person_register4,container,false);

        name=v.findViewById(id.informant_name);
        address=v.findViewById(id.informant_address);
        mobilenumber=v.findViewById(id.informant_number);
        landlinenumber=v.findViewById(id.informant_landline);
        email=v.findViewById(id.informant_email);
        Relation=v.findViewById(id.spinnerrelation);
        any_other_info=v.findViewById(id.informant_any_other_info);
        finish=v.findViewById(id.finish);

         db = FirebaseFirestore.getInstance();
         auth=FirebaseAuth.getInstance();
         MissingPersonFormInstance = Skel_MissingPersonForm.getInstance();



       Relation.setOnItemSelectedListener(this);

        ArrayAdapter relationadapter=new ArrayAdapter(getContext(),android.R.layout.simple_spinner_item,RelationName);
        relationadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Relation.setAdapter(relationadapter);


        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MissingPersonFormInstance.setInformantname( name.getText().toString());
                MissingPersonFormInstance.setInformantaddress( address.getText().toString());
                MissingPersonFormInstance.setInformantmobile( mobilenumber.getText().toString());
                MissingPersonFormInstance.setInformantlandline( landlinenumber.getText().toString());
                MissingPersonFormInstance.setInformantemail( email.getText().toString());
                MissingPersonFormInstance.setInformantrelation( takerelation);
                MissingPersonFormInstance.setAnyotherinfo( any_other_info.getText().toString());

                StoreData();

                Toast.makeText(getContext(),"finish",Toast.LENGTH_SHORT).show();
                //showDialog();
            }
        });

        return v;
    }

    private void StoreData() {
        // Create a new user with a first and last name

        Map<String, Object> user = new HashMap<>();
        Log.e("getdata",MissingPersonFormInstance.getName());
        //page registre 1
        user.put("first", MissingPersonFormInstance.getName());
        user.put("fathername",MissingPersonFormInstance.getFathername());
        user.put("address",MissingPersonFormInstance.getAddress());
        user.put("gender",MissingPersonFormInstance.getGender());
        user.put("year_of_birth",MissingPersonFormInstance.getDOB());
        user.put("age",MissingPersonFormInstance.getAge());
        user.put("height_from",MissingPersonFormInstance.getHeightfrom());
        user.put("height_to",MissingPersonFormInstance.getHeightto());
        user.put("weight",MissingPersonFormInstance.getWeight());
        user.put("complexion",MissingPersonFormInstance.getComplexion());
        //page registre 2
        user.put("incident_details",MissingPersonFormInstance.getIncidentdetails());
        user.put("incident_place",MissingPersonFormInstance.getIncidentplace());
        user.put("incident_time",MissingPersonFormInstance.getIncidenttime());
        user.put("incident_date",MissingPersonFormInstance.getIncidentdate());
        //page registre 3
        user.put("state",MissingPersonFormInstance.getState());
        user.put("district",MissingPersonFormInstance.getDistrict());
       //user.put("policestation",MissingPersonFormInstance.getPolicestation());
        user.put("photo",MissingPersonFormInstance.getPhoto());
        //page registre 4
        user.put("informant_name", MissingPersonFormInstance.getInformantname());
        user.put("informant_address",MissingPersonFormInstance.getInformantaddress());
        user.put("informant_mobile",MissingPersonFormInstance.getInformantmobile());
        user.put("informant_landline",MissingPersonFormInstance.getInformantlandline());
        user.put("informant_email",MissingPersonFormInstance.getInformantemail());
        user.put("informant_relation",MissingPersonFormInstance.getInformantrelation());
        user.put("any_other_info",MissingPersonFormInstance.getAnyotherinfo());

// Add a new document with a generated ID
        UID=auth.getCurrentUser().getUid();
        Log.e("tag","user created"+UID);

        DocumentReference documentReference=db.collection("users").document(UID);
        documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Log.e("tag","user created"+UID);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.e("tag","excepton"+e.toString());
            }
        });


    }

    private void showDialog() {
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        takerelation=Relation.getSelectedItem().toString();
        Toast.makeText(getContext(),"yess",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
