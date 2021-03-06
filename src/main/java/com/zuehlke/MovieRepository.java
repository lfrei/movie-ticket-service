package com.zuehlke;

import com.zuehlke.domain.MovieDetail;
import com.zuehlke.domain.Movie;
import com.zuehlke.domain.Rating;

import java.util.List;

import static java.util.Arrays.*;

public class MovieRepository {

    public static List<Movie> findAll() {
        return asList(
                new Movie(1, "Batman Begins", "https://images-na.ssl-images-amazon.com/images/M/MV5BNTM3OTc0MzM2OV5BMl5BanBnXkFtZTYwNzUwMTI3._V1_SX300.jpg"),
                new Movie(2, "Ted", "https://images-na.ssl-images-amazon.com/images/M/MV5BMTQ1OTU0ODcxMV5BMl5BanBnXkFtZTcwOTMxNTUwOA@@._V1_SX300.jpg"),
                new Movie(3, "Inception", "https://images-na.ssl-images-amazon.com/images/M/MV5BMjAxMzY3NjcxNF5BMl5BanBnXkFtZTcwNTI5OTM0Mw@@._V1_SX300.jpg"));
    }

    public static MovieDetail findById(int id) {
        MovieDetail movie = new MovieDetail(
                1,
                "Batman Begins",
                "https://images-na.ssl-images-amazon.com/images/M/MV5BNTM3OTc0MzM2OV5BMl5BanBnXkFtZTYwNzUwMTI3._V1_SX300.jpg",
                "After training with his mentor, Batman begins his fight to free crime-ridden Gotham City from the corruption that Scarecrow and the League of Shadows have cast upon it.",
                2005,
                "Action",
                asList(
                    new Rating("Internet Movie Database","8.3/10"),
                    new Rating("Rotten Tomatoes","84%")));

        return movie;
    }
}
