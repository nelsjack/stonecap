package com.techelevator.dao;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


import java.util.ArrayList;
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
        ResponseEntity<LinkedHashMap> response = restTemplate.getForEntity(API_BASE_URL + "boardgame/" + boardGameID, LinkedHashMap.class);
        LinkedHashMap objectFromRequest = response.getBody();
        Integer userId = (Integer) objectFromRequest.get("userId");

        // Then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(userId).isEqualTo(1);
    }

//    WishlistTest
    @Test
    void givenAUsernameHasWishlistGamesInTheDatabase_WhenTheUsernameIsSentToTheEndpoint_ThenTheCorrectListOfBoardGamesWishlistIsReturned() {
        // Given
        String username = "user1";
        String expectedEoardgame1 = "3IPVIROfvl";
        String expectedEoardgame2 = "OIXt3DmJU0";

        // When
        ResponseEntity<ArrayList> response = restTemplate.getForEntity(API_BASE_URL + "/boardgame/"+username+"/wishlist", ArrayList.class);
        ArrayList listOfGames = response.getBody();
        String actualGame1 = (String) ((LinkedHashMap) listOfGames.get(0)).get("boardGameId");
        String actualGame2 = (String) ((LinkedHashMap) listOfGames.get(1)).get("boardGameId");


        // Then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(listOfGames.size()).isEqualTo(2);
        assertThat(actualGame1).isEqualTo(expectedEoardgame1);
        assertThat(actualGame2).isEqualTo(expectedEoardgame2);

    }
//    TODO Played Games by user name
@Test
void givenAUsernameHasPlayedGamesInTheDatabase_WhenTheUsernameIsSentToTheEndpoint_ThenTheCorrectListOfBoardGamesPlayedIsReturned() {
    // Given
    String username = "user1";
    String expectedEoardgame1 = "TAAifFP590";
    String expectedEoardgame2 = "yqR4PtpO8X";

    // When
    ResponseEntity<ArrayList> response = restTemplate.getForEntity(API_BASE_URL + "/boardgame/"+username+"/played", ArrayList.class);
    ArrayList listOfGames = response.getBody();
    String actualGame1 = (String) ((LinkedHashMap) listOfGames.get(0)).get("boardGameId");
    String actualGame2 = (String) ((LinkedHashMap) listOfGames.get(1)).get("boardGameId");


    // Then
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    assertThat(listOfGames.size()).isEqualTo(2);
    assertThat(actualGame1).isEqualTo(expectedEoardgame1);
    assertThat(actualGame2).isEqualTo(expectedEoardgame2);

}
    //    TODO  create a post
    //    TODO  get/create friend

   //getfriend

}
