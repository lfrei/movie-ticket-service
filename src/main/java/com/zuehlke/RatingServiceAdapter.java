package com.zuehlke;

import com.zuehlke.domain.Rating;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class RatingServiceAdapter {

    private final RatingServiceApiClient ratingApiClient;

    public RatingServiceAdapter(String url) {
        ratingApiClient = RestClientFactory.createClient(url, RatingServiceApiClient.class);
    }

    public List<Rating> getRatingsById(long id) {
        return ratingApiClient.getRatingsById(id).stream().map(Rating::fromResponse).collect(toList());
    }
}