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
import com.example.chaatralay.Model.getApplicationRecyclerModel;
import com.example.chaatralay.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import jp.wasabeef.picasso.transformations.CropCircleTransformation;

public class RecyclerApplicationAdapter extends RecyclerView.Adapter<RecyclerApplicationAdapter.ViewHolder> {

    private Context ctx;
    private List<getApplicationRecyclerModel> applicationList;
    private static final String TAG = "RecyclerAdapter";

    public RecyclerApplicationAdapter(Context ctx, List<getApplicationRecyclerModel> applicationList) {
        this.ctx = ctx;
        this.applicationList = applicationList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_row,parent,false);

        return new RecyclerApplicationAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

//        final getApp
        final getApplicationRecyclerModel item = applicationList.get(position);
        holder.hostelTv.setText(item.getTodate());
        holder.courseTv.setText(item.getFromdate());
        holder.student_nameTv.setText(item.getReason());
        Picasso.get().load(item.getImg_url()).transform(new CropCircleTransformation()).into(holder.imgIg);
        try {
            holder.cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i=new Intent(ctx, Profile.class);

                    Log.d(TAG, "onClick: hiii "+item.getSid());
                    i.putExtra("id",item.getSid());
                    i.putExtra("reason",item.getReason());
                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    ctx.startActivity(i);
                }
            });
        } catch (Exception e) {
            Toast.makeText(ctx, e.toString(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public int getItemCount() {
        return applicationList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView student_nameTv, courseTv, hostelTv;
        public ImageView imgIg;
        public CardView cardView;
        public ViewHolder(@NonNull View view) {
            super(view);
            student_nameTv = view.findViewById(R.id.student_nameTV);
            courseTv = view.findViewById(R.id.courseTv);
            hostelTv = view.findViewById(R.id.hostelTv);
            imgIg = view.findViewById(R.id.studentimageIv);
            cardView=view.findViewById(R.id.card_view);
        }
    }
}
