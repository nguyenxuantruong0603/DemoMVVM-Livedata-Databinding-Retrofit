package com.example.demomvvm.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.demomvvm.R;
import com.example.demomvvm.datamodel.Movie;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.Holder> {
    private List<Movie> movieList;
    private Context context;

    public MovieAdapter(List<Movie> movieList, Context context) {
        this.movieList = movieList;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        Movie movie = movieList.get(position);
        holder.tvId.setText(movie.getId() + "");
        holder.tvTitle.setText(movie.getTitle());
        Picasso.with(context)
                .load(movie.getThumbnailUrl())
                .error(R.drawable.user)
                .into(holder.imgPoster);

        holder.itemView.setOnClickListener(v -> {
            Toast.makeText(context, movie.getUrl() + "", Toast.LENGTH_SHORT).show();
            Log.e("URL", movie.getUrl() + "\n" + movie.getThumbnailUrl());
        });
    }

    @Override
    public int getItemCount() {
        if (movieList != null) {
            return movieList.size();
        }
        return 0;
    }

    public class Holder extends RecyclerView.ViewHolder {

        ImageView imgPoster;
        TextView tvId;
        TextView tvTitle;

        public Holder(@NonNull View itemView) {
            super(itemView);

            imgPoster = itemView.findViewById(R.id.imgPoster);
            tvId = itemView.findViewById(R.id.tvId);
            tvTitle = itemView.findViewById(R.id.tvTitle);


        }
    }
}
