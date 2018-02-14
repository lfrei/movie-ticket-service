package com.zuehlke;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MovieTicketServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieTicketServiceApplication.class, args);
	}

	@Bean
	MovieServiceAdapter createMovieServiceAdapter() {
		return new MovieServiceAdapter("https://movie-service.herokuapp.com");
	}

	@Bean
	RatingServiceAdapter createRatingServiceAdapter() {
		return new RatingServiceAdapter("https://movie-rating-service.herokuapp.com");
	}
}
