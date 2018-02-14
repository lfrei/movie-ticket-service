package com.zuehlke.domain;


import com.zuehlke.RatingServiceResponse;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class Rating {
    private String source;
    private String value;

    public Rating(String source, String value) {
        this.source = source;
        this.value = value;
    }

    public static Rating fromResponse(RatingServiceResponse response) {
        return new Rating(response.getSource(), response.getValue());
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Rating rating = (Rating) o;

        return new EqualsBuilder()
                .append(source, rating.source)
                .append(value, rating.value)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(source)
                .append(value)
                .toHashCode();
    }
}
