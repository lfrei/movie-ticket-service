package com.zuehlke;

import com.zuehlke.domain.MovieDetail;
import com.zuehlke.domain.Movie;
import com.zuehlke.domain.Rating;

import java.util.ArrayList;
import java.util.List;

public class MovieRepository {

    public static List<Movie> findAll() {
        List<Movie> movies = new ArrayList<>();

        Movie batman = new Movie();
        batman.setId(1);
        batman.setTitle("Batman Begins");
        batman.setPoster("https://images-na.ssl-images-amazon.com/images/M/MV5BNTM3OTc0MzM2OV5BMl5BanBnXkFtZTYwNzUwMTI3._V1_SX300.jpg");

        Movie ted = new Movie();
        ted.setId(2);
        ted.setTitle("Ted");
        ted.setPoster("https://images-na.ssl-images-amazon.com/images/M/MV5BMTQ1OTU0ODcxMV5BMl5BanBnXkFtZTcwOTMxNTUwOA@@._V1_SX300.jpg");

        Movie inception = new Movie();
        inception.setId(3);
        inception.setTitle("Inception");
        inception.setPoster("https://images-na.ssl-images-amazon.com/images/M/MV5BMjAxMzY3NjcxNF5BMl5BanBnXkFtZTcwNTI5OTM0Mw@@._V1_SX300.jpg");

        movies.add(batman);
        movies.add(ted);
        movies.add(inception);

        return movies;
    }

    public static MovieDetail findById(int id) {
        MovieDetail movie = new MovieDetail();
        movie.setId(1);
        movie.setTitle("Batman Begins");
        movie.setPoster("https://images-na.ssl-images-amazon.com/images/M/MV5BNTM3OTc0MzM2OV5BMl5BanBnXkFtZTYwNzUwMTI3._V1_SX300.jpg");
        movie.setPlot("After training with his mentor, Batman begins his fight to free crime-ridden Gotham City from the corruption that Scarecrow and the League of Shadows have cast upon it.");
        movie.setYear(2005);
        movie.setGenre("Action");

        Rating imdbRating = new Rating();
        imdbRating.setSource("Internet MovieDetail Database");
        imdbRating.setValue("8.3/10");

        Rating tomatoes = new Rating();
        tomatoes.setSource("Rotten Tomatoes");
        tomatoes.setValue("84%");

        List<Rating> ratings = new ArrayList<>();
        ratings.add(imdbRating);
        ratings.add(tomatoes);
        movie.setRatings(ratings);

        return movie;
    }
}
