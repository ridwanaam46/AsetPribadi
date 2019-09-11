package com.example.asetpribadi.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.asetpribadi.Detail;
import com.example.asetpribadi.R;
import com.example.asetpribadi.Share;
import com.example.asetpribadi.object.AsetPribadi;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CardViewAdapter extends RecyclerView.Adapter<CardViewAdapter.ViewHolder>{
    private Context context;
    private ArrayList<AsetPribadi> data;
    private int layoutType;

    public CardViewAdapter(Context context) {
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

        TextView nameTeam, yearTeam;
        ImageView imageViewTeam;
        Button buttonShare, buttonFavorite;

        public ViewHolder(View itemView) {
            super(itemView);
            // -------------------------------------------------------------------------------------
            imageViewTeam = itemView.findViewById(R.id.content_image_photo);
            nameTeam = itemView.findViewById(R.id.content_textview_team);
            yearTeam = itemView.findViewById(R.id.content_textview_year);
            buttonShare = itemView.findViewById(R.id.btn_set_share);
            buttonFavorite = itemView.findViewById(R.id.btn_set_favorite);
            // -------------------------------------------------------------------------------------
        }
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        Picasso.get().load(data.get(position).getIntGambar()).into(holder.imageViewTeam);
        holder.yearTeam.setText(data.get(position).getMerk());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentData = new Intent(context, Detail.class);
                AsetPribadi parcelTeam = data.get(position);
                intentData.putExtra(Detail.EXTRA_TEAM, parcelTeam);
                context.startActivity(intentData);
            }
        });

        holder.buttonFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Favorite " + data.get(position).getMerk(), Toast.LENGTH_SHORT).show();
            }
        });

        holder.buttonShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Share " + data.get(position).getMerk(), Toast.LENGTH_SHORT).show();
                Intent intentData = new Intent(context, Share.class);
                AsetPribadi parcelTeam = data.get(position);
                intentData.putExtra(Share.EXTRA_TEAM, parcelTeam);
                context.startActivity(intentData);
            }
        });

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext()).inflate(layoutType, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

}

