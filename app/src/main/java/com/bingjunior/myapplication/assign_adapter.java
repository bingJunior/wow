package com.bingjunior.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class assign_adapter extends RecyclerView.Adapter<com.student.crimnalalert.assign_adapter.ViewHolder> {
    Context context;
    ArrayList<com.student.crimnalalert.assign_userdatabasehelper> emailarray=new ArrayList<>();

    public assign_adapter(Context context, ArrayList<com.student.crimnalalert.assign_userdatabasehelper> emailarray) {
        this.context = context;
        this.emailarray = emailarray;
    }

    public assign_adapter() {
    }

    @NonNull
    @Override
    public com.student.crimnalalert.assign_adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_assign_adapter,null);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull com.student.crimnalalert.assign_adapter.ViewHolder holder, int position) {
        holder.email.setText(emailarray.get(position).getEmail());

    }

    @Override
    public int getItemCount() {
        return emailarray.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView email,pass;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            email=itemView.findViewById(R.id.emailid);
            pass=itemView.findViewById(R.id.passwordid);
        }
    }
}