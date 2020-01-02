package com.example.chaatralay.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chaatralay.R;
import com.example.chaatralay.Model.RecyclerviewImagesModel;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyclerImageAdapter extends RecyclerView.Adapter<RecyclerImageAdapter.ViewHolder> {
    private Context ctx;
    private List<RecyclerviewImagesModel> imageList;

    public RecyclerImageAdapter(Context ctx, List<RecyclerviewImagesModel> imageList) {
        this.ctx = ctx;
        this.imageList = imageList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_image,parent,false);

        return new RecyclerImageAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final RecyclerviewImagesModel item = imageList.get(position);

        Picasso.get().load(item.getImg_url()).into(holder.img);
    }

    @Override
    public int getItemCount() {
        return imageList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView img;
        public ViewHolder(@NonNull View view) {
            super(view);
            img = view.findViewById(R.id.photoIv);
        }
    }
}
