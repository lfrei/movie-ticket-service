package com.zuehlke;

import com.zuehlke.domain.MovieDetail;
import com.zuehlke.domain.Movie;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class MovieController {

    @GetMapping("/movies")
    public List<Movie> getMovies() {
        return MovieRepository.findAll();
    }

    @GetMapping("/movies/{id}")
    public MovieDetail getMovie(@PathVariable("id") int id) {
        return MovieRepository.findById(id);
    }
}
