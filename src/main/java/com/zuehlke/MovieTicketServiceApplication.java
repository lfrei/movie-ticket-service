package com.zuehlke;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MovieTicketServiceApplication {

	@Value("${endpoint.movie-service}")
	private String movieServiceEndpoint;

	@Value("${endpoint.movie-rating-service}")
	private String ratingServiceEndpoint;

	public static void main(String[] args) {
		SpringApplication.run(MovieTicketServiceApplication.class, args);
	}

	@Bean
	MovieServiceAdapter createMovieServiceAdapter() {
		return new MovieServiceAdapter(movieServiceEndpoint);
	}

	@Bean
	RatingServiceAdapter createRatingServiceAdapter() {
		return new RatingServiceAdapter(ratingServiceEndpoint);
	}
}
