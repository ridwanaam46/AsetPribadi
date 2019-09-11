package com.example.asetpribadi.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.asetpribadi.Detail;
import com.example.asetpribadi.R;
import com.example.asetpribadi.object.AsetPribadi;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class GridViewAdapter extends RecyclerView.Adapter<GridViewAdapter.ViewHolder>{
    private Context context;
    private ArrayList<AsetPribadi> data;
    private int layoutType;

    public GridViewAdapter(Context context) {
        this.context = context;
    }

    public void addItem(ArrayList<AsetPribadi> data){
        this.data = data;
        notifyDataSetChanged();
    }

    public void setLayoutType(int mLayoutType){
        this.layoutType = mLayoutType;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageViewTeam;

        public ViewHolder(View itemView) {
            super(itemView);
            // -------------------------------------------------------------------------------------
            imageViewTeam = itemView.findViewById(R.id.content_image_photo);
            // -------------------------------------------------------------------------------------
        }
    }

    @Override
    public void onBindViewHolder(final GridViewAdapter.ViewHolder holder, final int position) {
        Picasso.get().load(data.get(position).getIntGambar()).into(holder.imageViewTeam);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentData = new Intent(context, Detail.class);
                AsetPribadi parcelTeam = data.get(position);
                intentData.putExtra(Detail.EXTRA_TEAM, parcelTeam);
                context.startActivity(intentData);
            }
        });

    }

    @NonNull
    @Override
    public GridViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext()).inflate(layoutType, parent, false);
        return new GridViewAdapter.ViewHolder(v);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

}

