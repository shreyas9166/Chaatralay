package com.example.chaatralay.Adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chaatralay.Activities.Profile;
import com.example.chaatralay.Model.RecyclerviewImagesModel;
import com.example.chaatralay.Model.RecyclerviewModel;
import com.example.chaatralay.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import jp.wasabeef.picasso.transformations.CropCircleTransformation;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {



    private Context ctx;
    private List<RecyclerviewModel> studentList;

    public RecyclerAdapter(Context ctx, List<RecyclerviewModel> studentList) {
        this.ctx = ctx;
        this.studentList = studentList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_row,parent,false);

        return new RecyclerAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final RecyclerviewModel item = studentList.get(position);
        holder.hostelTv.setText(item.getHostel());
        holder.courseTv.setText(item.getDist());
        holder.student_nameTv.setText(item.getName());
        Picasso.get().load(item.getImg_url()).transform(new CropCircleTransformation()).into(holder.imgIg);

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(ctx, Profile.class);


                i.putExtra("id",item.getId());
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                ctx.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView student_nameTv,courseTv,hostelTv;
        public ImageView imgIg;
        public CardView cardView;
        public ViewHolder(@NonNull View view) {
            super(view);
            student_nameTv = view.findViewById(R.id.student_nameTV);
            courseTv=view.findViewById(R.id.courseTv);
            hostelTv=view.findViewById(R.id.hostelTv);
            imgIg=view.findViewById(R.id.studentimageIv);
            cardView = view.findViewById(R.id.card_view);
        }
    }
}
