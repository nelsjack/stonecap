package com.techelevator.dao;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


import java.util.LinkedHashMap;

import static org.assertj.core.api.Assertions.assertThat;


//https://www.baeldung.com/integration-testing-a-rest-api
public class EndPointTests {
    public static String API_BASE_URL = "http://localhost:9000/";
    private RestTemplate restTemplate = new RestTemplate();
    @Test
    void givenBoardGameIdDoesExistInBoardGameTable_WhenBoardGameIDIsSent_thenLinkedUserIsRetrieved() {
        // Given
        String boardGameID = "3IPVIROfvl";


        // When
       ResponseEntity<LinkedHashMap> response = restTemplate.getForEntity(API_BASE_URL + "boardgame/"+ boardGameID, LinkedHashMap.class);
       LinkedHashMap objectFromRequest = response.getBody();
        Integer userId = (Integer) objectFromRequest.get("userId");
        System.out.println(objectFromRequest);
        System.out.println(userId);
        // Then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(userId).isEqualTo(1);
    }


}
