package com.zuehlke.domain;

import com.zuehlke.MovieServiceResponse;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class Movie {
    private long id;
    private String title;
    private String poster;

    public Movie(long id, String title, String poster) {
        this.id = id;
        this.title = title;
        this.poster = poster;
    }

    public static Movie fromResponse(MovieServiceResponse response) {
        return new Movie(response.getId(), response.getTitle(), response.getPoster());
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Movie movie = (Movie) o;

        return new EqualsBuilder()
                .append(id, movie.id)
                .append(title, movie.title)
                .append(poster, movie.poster)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(title)
                .append(poster)
                .toHashCode();
    }
}
