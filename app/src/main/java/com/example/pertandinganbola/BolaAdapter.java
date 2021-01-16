package com.example.pertandinganbola;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.pertandinganbola.model.Bola;

import java.util.ArrayList;

public class BolaAdapter extends RecyclerView.Adapter<BolaAdapter.ListViewHolder> {

    private ArrayList<Bola> listBola;

    public BolaAdapter(ArrayList<Bola> listBola) {
        this.listBola = listBola;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row,parent,false);


        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        Bola bola = listBola.get(position);

        holder.txtTitle.setText(bola.getStrTeam());
        holder.txtTime.setText(bola.getIntFormedYear());
        holder.txtOverview.setText(bola.getStrDescriptionDE());

        Glide.with(holder.itemView)
                .load("https://www.thesportsdb.com/images/media/team/badge/"+bola.getStrTeamBadge())
                .into(holder.imgPoster);

    }

    @Override
    public int getItemCount() {
        return listBola.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        TextView txtTitle;
        TextView txtTime;
        TextView txtOverview;
        ImageView imgPoster;





        public ListViewHolder(@NonNull View itemView) {
            super(itemView);

            txtTitle = itemView.findViewById(R.id.txtTitle);
            txtTime = itemView.findViewById(R.id.txtTime);
            txtOverview = itemView.findViewById(R.id.txtOverview);
            imgPoster = itemView.findViewById(R.id.imgPoster);


        }
    }
}

