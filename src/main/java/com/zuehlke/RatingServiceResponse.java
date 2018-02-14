package com.zuehlke;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

// Class for converting json string to a java object
public class RatingServiceResponse {

    private final String source;
    private final String value;

    @JsonCreator
    public RatingServiceResponse(@JsonProperty("Source") String source,
                                 @JsonProperty("Value") String value) {
        this.source = source;
        this.value = value;
    }

    public String getSource() {
        return source;
    }

    public String getValue() {
        return value;
    }
}