package com.bingjunior.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.bingjunior.myapplication.Modal.filterMissPersonSearch;

public class filtermisspersonAdapter extends FirestoreRecyclerAdapter<filterMissPersonSearch,filtermisspersonAdapter.myviewholder> {
    private View view;

    public filtermisspersonAdapter(FirestoreRecyclerOptions options) {
        super(options);
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.filter_format, parent, false);

        return new myviewholder(view);
    }

    @Override
    protected void onBindViewHolder(filtermisspersonAdapter.myviewholder myviewholder, int i, filterMissPersonSearch filterMissPersonSearch) {

        myviewholder.name.setText(filterMissPersonSearch.getName());
        myviewholder.age.setText(filterMissPersonSearch.getAge());
        myviewholder.gender.setText(filterMissPersonSearch.getGender());
        myviewholder.DOB.setText(filterMissPersonSearch.getDOB());
        myviewholder.weight.setText(filterMissPersonSearch.getWeight());
        myviewholder.height.setText(filterMissPersonSearch.getHeight());
        myviewholder.complexion.setText(filterMissPersonSearch.getComplexion());

        Glide.with(view.getContext())
                .load(filterMissPersonSearch.getPhoto())
                .into(myviewholder.imageView);

    }


    public class myviewholder extends RecyclerView.ViewHolder {
                ImageView imageView;
        TextView name,age,gender,DOB,weight,height,complexion;
        CardView cardView;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
                        imageView = itemView.findViewById(R.id.image);
            name = itemView.findViewById(R.id.name);
            age = itemView.findViewById(R.id.age);
            gender = itemView.findViewById(R.id.gender);
            DOB = itemView.findViewById(R.id.date);
            weight = itemView.findViewById(R.id.weight);
            height = itemView.findViewById(R.id.height);
            complexion = itemView.findViewById(R.id.complexion);
            cardView=itemView.findViewById(R.id.filtercard);
        }
    }
}


