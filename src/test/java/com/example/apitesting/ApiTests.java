package com.example.apitesting;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ApiTests extends ApiTestBase {

    @Test
    public void testGetPosts() {
        Response response = RestAssured
                .given()
                .when()
                .get("/posts")
                .then()
                .assertThat()
                .statusCode(200)
                .and()
                .contentType(ContentType.JSON)
                .extract()
                .response();

        // Validate that the first post's title is as expected
        assertEquals("sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
                response.jsonPath().getString("title[0]"));
    }

    @Test
    public void testCreatePost() {
        String newPost = "{ \"title\": \"foo\", \"body\": \"bar\", \"userId\": 1 }";

        RestAssured
                .given()
                .header("Content-type", "application/json")
                .and()
                .body(newPost)
                .when()
                .post("/posts")
                .then()
                .assertThat()
                .statusCode(201)
                .and()
                .body("title", equalTo("foo"))
                .and()
                .body("body", equalTo("bar"));
    }

    @Test
    public void testUpdatePost() {
        String updatedPost = "{ \"id\": 1, \"title\": \"new title\", \"body\": \"updated body\", \"userId\": 1 }";

        RestAssured
                .given()
                .header("Content-type", "application/json")
                .and()
                .body(updatedPost)
                .when()
                .put("/posts/1")
                .then()
                .assertThat()
                .statusCode(200)
                .and()
                .body("title", equalTo("new title"))
                .and()
                .body("body", equalTo("updated body"));
    }

    @Test
    public void testDeletePost() {
        RestAssured
                .given()
                .when()
                .delete("/posts/1")
                .then()
                .assertThat()
                .statusCode(200);
    }
}
