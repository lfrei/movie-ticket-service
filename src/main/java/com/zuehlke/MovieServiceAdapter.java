package com.zuehlke;

import com.netflix.hystrix.exception.HystrixRuntimeException;
import com.zuehlke.domain.Movie;
import com.zuehlke.domain.MovieDetail;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

public class MovieServiceAdapter {

    private final MovieServiceApiClient moviesApiClient;

    public MovieServiceAdapter(String url) {
        moviesApiClient = RestClientFactory.createClient(url, MovieServiceApiClient.class);
    }

    public List<Movie> getAll() {
        return moviesApiClient.getMovies().stream().map(Movie::fromResponse).collect(toList());
    }

    public Optional<MovieDetail> getMovieById(long id) {
        try {
            return Optional.of(MovieDetail.fromResponse(moviesApiClient.getMovieById(id)));
        } catch (HystrixRuntimeException e) {
            return Optional.empty();
        }
    }
}
