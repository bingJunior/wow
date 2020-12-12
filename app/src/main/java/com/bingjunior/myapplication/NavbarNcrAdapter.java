package com.bingjunior.myapplication;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;

import androidx.recyclerview.widget.RecyclerView;

import com.bingjunior.myapplication.NCR_REGISTER.FoundArticle;
import com.bingjunior.myapplication.NCR_REGISTER.LostArticle;
import com.bingjunior.myapplication.NCR_REGISTER.MissPersonReport;
import com.bingjunior.myapplication.NCR_REGISTER.MissingChildrenReport;
import com.bingjunior.myapplication.NCR_REGISTER.MissingChildrenSearch;
import com.bingjunior.myapplication.NCR_REGISTER.MissingPersonSearch;


public class NavbarNcrAdapter extends  RecyclerView.Adapter<NavbarNcrAdapter.ViewHolder> {
    private  View view;
    //private Context context;

    Integer images[]={R.drawable.nav_missing_person,R.drawable.nav_missing_person_search,
            R.drawable.nav_missingchildrensearch,R.drawable.ic_childlost,R.drawable.nav_lost_found,R.drawable.ic_found};
    String title[]={"Missing Person Report","Missing Person Search","Missing Child Search",
            "Lost Child Report","Lost Articles","Found Articles"};

    @NonNull
    @Override
    public NavbarNcrAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

    view= LayoutInflater.from(parent.getContext()).inflate(R.layout.navbarncradapter,parent,false);
        //View view=inflater.inflate(R.layout.activity_fir_register_adapter,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        holder.textView.setText(title[position]);
        holder.imageView.setImageResource(images[position]);

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(holder.getAdapterPosition()==0){
                    Intent intent = new Intent(view.getContext(), MissPersonReport.class);
                    view.getContext().startActivity(intent);
                }
                else if(holder.getAdapterPosition()==1){
                    Intent intent = new Intent(view.getContext(), MissingPersonSearch.class);
                    view.getContext().startActivity(intent);
                }
                else if(holder.getAdapterPosition()==2){
                    Intent intent = new Intent(view.getContext(), MissingChildrenSearch.class);
                    view.getContext().startActivity(intent);
                }
                else if(holder.getAdapterPosition()==3){
                    Intent intent = new Intent(view.getContext(), MissingChildrenReport.class);
                    view.getContext().startActivity(intent);
                }
                else if(holder.getAdapterPosition()==4){
                    Intent intent = new Intent(view.getContext(), LostArticle.class);
                    view.getContext().startActivity(intent);
                }
                else if(holder.getAdapterPosition()==5){
                    Intent intent = new Intent(view.getContext(), FoundArticle.class);
                    view.getContext().startActivity(intent);
                }

            }
        });

    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageid);
            textView = itemView.findViewById(R.id.textid);
            cardView=itemView.findViewById(R.id.carditemid);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(view.getContext(), "cliked" + getAdapterPosition(), Toast.LENGTH_SHORT).show();
                }
            });

        }
    }
}
