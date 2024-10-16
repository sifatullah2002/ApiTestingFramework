package com.example.apitesting;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;

public class ApiTestBase {

    @BeforeEach
    public void setUp() {
        // Base URL for the API
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }
}
