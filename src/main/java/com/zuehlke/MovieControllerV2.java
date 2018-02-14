package com.zuehlke;

import com.zuehlke.domain.Movie;
import com.zuehlke.domain.MovieDetail;
import com.zuehlke.domain.Rating;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v2")
public class MovieControllerV2 {

    private final MovieServiceAdapter movieServiceAdapter;
    private final RatingServiceAdapter ratingAdapter;

    public MovieControllerV2(MovieServiceAdapter movieServiceAdapter, RatingServiceAdapter ratingAdapter) {
        this.movieServiceAdapter = movieServiceAdapter;
        this.ratingAdapter = ratingAdapter;
    }

    @GetMapping("/movies")
    public List<Movie> getMovies() {
        return movieServiceAdapter.getAll();
    }

    @GetMapping("/movies/{id}")
    public MovieDetail getMovieById(@PathVariable("id") int id) throws Exception {
        Optional<MovieDetail> movieDetail = movieServiceAdapter.getMovieById(id);
        List<Rating> ratings = ratingAdapter.getRatingsById(id);

        return movieDetail.map(m -> m.setRatings(ratings))
                .orElseThrow(() -> new MovieNotFoundException("No movie found with id=" + id));
    }
}
