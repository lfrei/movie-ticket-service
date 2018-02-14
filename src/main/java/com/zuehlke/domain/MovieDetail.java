package com.zuehlke.domain;

import com.zuehlke.MovieServiceResponse;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import java.util.Collections;
import java.util.List;

public class MovieDetail extends Movie {
    private String plot;
    private int year;
    private String genre;
    private List<Rating> ratings;

    public MovieDetail(long id, String title, String poster, String plot, int year, String genre, List<Rating> ratings) {
        super(id, title, poster);
        this.plot = plot;
        this.year = year;
        this.genre = genre;
        this.ratings = ratings;
    }

    public static MovieDetail fromResponse(MovieServiceResponse response) {
        return new MovieDetail(
                response.getId(),
                response.getTitle(),
                response.getPoster(),
                response.getPlot(),
                response.getYear(),
                response.getGenre(),
                Collections.emptyList());
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public MovieDetail setRatings(List<Rating> ratings) {
        this.ratings = ratings;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        MovieDetail that = (MovieDetail) o;

        return new EqualsBuilder()
                .appendSuper(super.equals(o))
                .append(year, that.year)
                .append(plot, that.plot)
                .append(genre, that.genre)
                .append(ratings, that.ratings)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .appendSuper(super.hashCode())
                .append(plot)
                .append(year)
                .append(genre)
                .append(ratings)
                .toHashCode();
    }
}
