//package com.bingjunior.myapplication.Fragment;
//
//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.fragment.app.Fragment;
//
//import android.os.Bundle;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//
//import com.bingjunior.myapplication.R;
//
//public class layout_PROFILE extends Fragment {
//
//    View v;
//    @Nullable
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//
//        v=inflater.inflate(R.layout.activity_layout__p_r_o_f_i_l_e,container,false);
//        return v;
//    }
//}
package com.bingjunior.myapplication.Fragment;

        import androidx.annotation.NonNull;
        import androidx.annotation.Nullable;
        import androidx.appcompat.app.AppCompatActivity;
        import androidx.fragment.app.Fragment;

        import android.content.Intent;
        import android.graphics.Color;
        import android.os.Bundle;
        import android.text.Editable;
        import android.text.TextWatcher;
        import android.util.Log;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.TextView;
        import android.widget.Toast;

        import com.google.android.gms.tasks.OnCompleteListener;
        import com.google.android.gms.tasks.OnFailureListener;
        import com.google.android.gms.tasks.OnSuccessListener;
        import com.google.android.gms.tasks.Task;
        import com.google.android.material.navigation.NavigationView;
        import com.google.firebase.auth.FirebaseAuth;
        import com.google.firebase.auth.FirebaseUser;
        import com.google.firebase.database.ChildEventListener;
        import com.google.firebase.database.DataSnapshot;
        import com.google.firebase.database.DatabaseError;
        import com.google.firebase.database.DatabaseReference;
        import com.google.firebase.database.FirebaseDatabase;
        import com.google.firebase.database.ValueEventListener;
        import com.bingjunior.myapplication.R;
        import com.bingjunior.myapplication.assign_userdatabasehelper;

        import java.util.HashMap;

public class layout_PROFILE extends Fragment {

    View v;
    EditText UserName;
    EditText UserEmail;
    EditText UserNumber;
    EditText UserPassword;
    Button change;
    String email;
    FirebaseUser user;
    DatabaseReference userRef;
    public static  String fetchnamedb;
    public static  String fetchemaildb;
    public static  String fetchnumberdb;
    public static  String fetchpassworddb;

    public  static  final String Users="UserData";

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        v=inflater.inflate(R.layout.activity_layout__p_r_o_f_i_l_e,container,false);

        Bundle bundle=this.getArguments();
        email=bundle.getString("email");
        Toast.makeText(getContext(),""+email,Toast.LENGTH_LONG);

        UserName=v.findViewById(R.id.username);
        UserEmail=v.findViewById(R.id.useremail);
        UserNumber=v.findViewById(R.id.usermobilenumber);
        UserPassword=v.findViewById(R.id.userpassword);
        change=v.findViewById(R.id.change);
        userRef=FirebaseDatabase.getInstance().getReference(Users);
        user=FirebaseAuth.getInstance().getCurrentUser();

        userRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for(DataSnapshot ds:dataSnapshot.getChildren())
                {
                    Log.e("tag", String.valueOf(ds.child("email").getValue()));

                    if(ds.child("email").getValue().equals("gargpriya812@gmail.com"))
                    {
                         fetchnamedb=  ds.child("name").getValue(String.class);
                         fetchemaildb=ds.child("email").getValue(String.class);
                         fetchnumberdb=ds.child("mobilenumber").getValue(String.class);
                         fetchpassworddb=ds.child("password").getValue(String.class);

                        UserName.setText(fetchnamedb);
                        UserEmail.setText(fetchemaildb);
                        UserPassword.setText(fetchpassworddb);
                        UserNumber.setText(fetchnumberdb);
                    }
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("fetchname",""+fetchnamedb);
                Log.e("entername",""+UserName.getText().toString());

                if(isnamechanged() ||isemailchanged() || isnumberchanged() || ispasswordchanged()){
                    Toast.makeText(getContext()," updates changess",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getContext()," No changess",Toast.LENGTH_SHORT).show();
                }

            }
        });

        super.onViewCreated(view, savedInstanceState);
    }

    private boolean ispasswordchanged() {
        if(!fetchpassworddb.matches(UserPassword.getText().toString())) {
            userRef.child(fetchnumberdb).child("password").setValue(UserPassword.getText().toString());
            fetchpassworddb=UserPassword.getText().toString();
            user.updatePassword(fetchpassworddb).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void aVoid) {
                    Log.e("updated authencation","yessss");
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Log.e("updated authencation","Nooo");
                }
            });
            return true;
        }
        else {
            return false;
        }
    }

    private boolean isnumberchanged() {
        if(!fetchnumberdb.matches(UserNumber.getText().toString())) {
            userRef.child(fetchnumberdb).child("mobilenumber").setValue(UserNumber.getText().toString());
            fetchnumberdb=UserNumber.getText().toString();
            return true;
        }
        else {
            return false;
        }
    }

    private boolean isemailchanged() {
        if(!fetchemaildb.matches(UserEmail.getText().toString())) {
            userRef.child(fetchnumberdb).child("email").setValue(UserEmail.getText().toString());
            fetchemaildb=UserEmail.getText().toString();

            user.updateEmail(fetchemaildb).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void aVoid) {
                    Log.e("updated authencation","yessss");
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Log.e("updated authencation","Nooo");
                }
            });
            return true;
        }
        else {
            return false;
        }
    }

    private boolean isnamechanged() {
        if(!fetchnamedb.matches(UserName.getText().toString())) {
            userRef.child(fetchnumberdb).child("name").setValue(UserName.getText().toString());
            fetchnamedb=UserName.getText().toString();
            return true;
        }
        else {
            return false;
        }
    }
}