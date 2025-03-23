package online.mrgutter.week10.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import android.support.v7.widget.RecyclerView;
import java.util.List;

import online.mrgutter.week10.R;
import online.mrgutter.week10.model.Movie;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {
    private List<Movie> movies;

    // Constructor
    public MovieAdapter(List<Movie> movies) {
        this.movies = movies;
    }


    @Override
    public MovieViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_itemcard, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {
        Movie movie = movies.get(position);
        holder.titleTextView.setText(movie.getTitle());
        holder.yearTextView.setText(String.valueOf(movie.getYear()));
        holder.genreTextView.setText(movie.getGener());
    }

    @Override
    public int getItemCount() {
        return movies != null ? movies.size() : 0;
    }

    // Update movies list
    public void updateMovies(List<Movie> newMovies) {
        this.movies = newMovies;
        notifyDataSetChanged();
    }

    // ViewHolder Class
    public static class MovieViewHolder extends RecyclerView.ViewHolder {
        TextView titleTextView, yearTextView, genreTextView;

        public MovieViewHolder(View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.textViewTitle);
            yearTextView = itemView.findViewById(R.id.textViewYear);
            genreTextView = itemView.findViewById(R.id.textViewGener);
        }
    }
}


