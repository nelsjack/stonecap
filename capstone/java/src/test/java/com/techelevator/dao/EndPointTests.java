package com.techelevator.dao;

import com.techelevator.model.Friend;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


import java.util.ArrayList;
import java.util.LinkedHashMap;

import static org.assertj.core.api.Assertions.assertThat;
//TODO fix raw use of parameterized classes

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
        String expectedBoardgame1 = "3IPVIROfvl";
        String expectedBoardgame2 = "OIXt3DmJU0";

        // When
        ResponseEntity<ArrayList> response = restTemplate.getForEntity(API_BASE_URL + "/boardgame/"+username+"/wishlist", ArrayList.class);
        ArrayList listOfGames = response.getBody();
        String actualGame1 = (String) ((LinkedHashMap) listOfGames.get(0)).get("boardGameId");
        String actualGame2 = (String) ((LinkedHashMap) listOfGames.get(1)).get("boardGameId");


        // Then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(listOfGames.size()).isEqualTo(2);
        assertThat(actualGame1).isEqualTo(expectedBoardgame1);
        assertThat(actualGame2).isEqualTo(expectedBoardgame2);

    }
//    TODO Played Games by user name
@Test
void givenAUsernameHasPlayedGamesInTheDatabase_WhenTheUsernameIsSentToTheEndpoint_ThenTheCorrectListOfBoardGamesPlayedIsReturned() {
    // Given
    String username = "user1";
    String expectedBoardgame1 = "TAAifFP590";
    String expectedBoardgame2 = "yqR4PtpO8X";

    // When
    ResponseEntity<ArrayList> response = restTemplate.getForEntity(API_BASE_URL + "/boardgame/"+username+"/played", ArrayList.class);
    ArrayList listOfGames = response.getBody();
    String actualGame1 = (String) ((LinkedHashMap) listOfGames.get(0)).get("boardGameId");
    String actualGame2 = (String) ((LinkedHashMap) listOfGames.get(1)).get("boardGameId");


    // Then
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    assertThat(listOfGames.size()).isEqualTo(2);
    assertThat(actualGame1).isEqualTo(expectedBoardgame1);
    assertThat(actualGame2).isEqualTo(expectedBoardgame2);

}
    //    TODO  create a post
    //    TODO  get/create friend
// create friend
    @Test
    void givenAUserIsNotFriendsWithAnotherUser_WhenTheUserSendsTheirAndTheNewFriendId_ThenTheFriendEntryIsAddedToFriendsTable() {
//        // Given
//        Friend newFriend3to4 = new Friend(-1,3,4);
//
//
//        // When
//        System.out.println("before query");
//        ResponseEntity<Friend> response1 = restTemplate.getForEntity(API_BASE_URL + "/user/"+inputuserId1+"/friends", Friend.class);
//        Friend actualFriendship = response1.getBody();
//        Integer actualUser1 = actualFriendship.getUserIdOne();
//        Integer actualUser2 = actualFriendship.getUserIdTwo();
//        ResponseEntity<ArrayList> response2 = restTemplate.getForEntity(API_BASE_URL + "/user/"+inputUserId2+"/friends", ArrayList.class);
//        ArrayList listOfFriends2 = response2.getBody();
//        Integer actualUser2 = (Integer) (listOfFriends2.get(0));
//
//
//
//        // Then
//        assertThat(response1.getStatusCode()).isEqualTo(HttpStatus.OK);
//        assertThat(listOfFriends1.size()).isEqualTo(1);
//        assertThat(actualUser1).isEqualTo(expectedUserId1);
//        assertThat(actualUser2).isEqualTo(expectedUserId2);


    }
   //getfriend
   @Test
   void givenAUserHasFriendsInTheDatabase_WhenTheUsernameIsSentToTheEndpoint_ThenTheCorrectListOfFriendsIsReturned() {
       // Given
       String inputuserId1 = "1";
       String inputUserId2 = "2";
       Integer expectedUserId1 = 2;
       Integer expectedUserId2 = 1;

       // When
       System.out.println("before query");
       ResponseEntity<ArrayList> response1 = restTemplate.getForEntity(API_BASE_URL + "/user/"+inputuserId1+"/friends", ArrayList.class);
       ArrayList listOfFriends1 = response1.getBody();
       Integer actualUser1 = (Integer) (listOfFriends1.get(0));

       ResponseEntity<ArrayList> response2 = restTemplate.getForEntity(API_BASE_URL + "/user/"+inputUserId2+"/friends", ArrayList.class);
       ArrayList listOfFriends2 = response2.getBody();
       Integer actualUser2 = (Integer) (listOfFriends2.get(0));



       // Then
       assertThat(response1.getStatusCode()).isEqualTo(HttpStatus.OK);
       assertThat(listOfFriends1.size()).isEqualTo(1);
       assertThat(actualUser1).isEqualTo(expectedUserId1);
       assertThat(actualUser2).isEqualTo(expectedUserId2);


   }
}
