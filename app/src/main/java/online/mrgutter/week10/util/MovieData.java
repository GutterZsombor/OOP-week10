package online.mrgutter.week10.util;

import java.util.List;

import online.mrgutter.week10final.model.Movie;

public class MovieData {
    //Not very usefull just a list of movies
   private List<Movie> movies;

    public MovieData() {
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
}
