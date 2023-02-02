package com.techelevator.dao;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.RestTemplate;


import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.assertj.core.api.Assertions.assertThat;


//https://www.baeldung.com/integration-testing-a-rest-api
public class EndPointTests {
    public static String API_BASE_URL = "https://localhost:8080/";
    private RestTemplate restTemplate = new RestTemplate();
    @Test
    void giveUserBoardDoesExistInCollection_WhenBoardGameIsRetrieved_thenBoardGameIsRetrieved() {
        // Given
        String boardGameID = "1";


        // When
       ResponseEntity<String> response = restTemplate.getForEntity(API_BASE_URL + "boardgame/"+ boardGameID, String.class);

        // Then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }


}
