package com.bingjunior.myapplication.NCRfragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;
import com.bingjunior.myapplication.Modal.filterMissPersonSearch;
import com.bingjunior.myapplication.NavbarNcrAdapter;
import com.bingjunior.myapplication.R;
import com.bingjunior.myapplication.filtermisspersonAdapter;

import java.util.ArrayList;

public class filterMissingPersonSearch extends Fragment
{
    private View v;
    private RecyclerView recyclerView;
    private FirebaseFirestore db=FirebaseFirestore.getInstance();
    filtermisspersonAdapter obj;
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        v=inflater.inflate(R.layout.filtermissingpersonsearch,container,false);
        recyclerView=v.findViewById(R.id.recyclerid);

       // Query query = db.collection("users");
        CollectionReference citiesRef = db.collection("users");

        Query query = citiesRef.whereEqualTo("gender", "Female");
        FirestoreRecyclerOptions<filterMissPersonSearch> response = new FirestoreRecyclerOptions.Builder<filterMissPersonSearch>()
                .setQuery(query, filterMissPersonSearch.class)
                .build();

        obj=new filtermisspersonAdapter(response);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(v.getContext(),RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(obj);

        return v;
    }
    @Override
    public void onStart() {
        super.onStart();
        obj.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        obj.stopListening();
    }
}
