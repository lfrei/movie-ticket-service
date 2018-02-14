package com.zuehlke;

import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MovieControllerComponentTest {

    @LocalServerPort
    private int port;

    @Before
    public void setUp() throws Exception {
        RestAssured.port = port;
    }

    @Test
    public void getMovies() throws Exception {
        when().get("/api/v1/movies").then()
                .statusCode(200)
                .body("[0].title", equalTo("Batman Begins"))
                .body("[1].title", equalTo("Ted"))
                .body("[2].title", equalTo("Inception"));

    }

    @Test
    public void getMovieById() throws Exception {
        when().get("/api/v1/movies/1").then()
                .statusCode(200)
                .body("id", is(1))
                .body("title", equalTo("Batman Begins"))
                .body("year", is(2005))
                .body("ratings[0].source", equalTo("Internet Movie Database"))
                .body("ratings[1].source", equalTo("Rotten Tomatoes"));
    }

}