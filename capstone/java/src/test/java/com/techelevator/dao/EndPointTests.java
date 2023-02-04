package com.techelevator.dao;

import com.techelevator.model.Friend;
import com.techelevator.model.Post;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

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
    @Test
    void givenAUserEnteredValidData_WhenTheUserSubmitsAPost_ThenThePostIsReturnedAndStatusIsCreated() {

        // Given
        String testTags = "Tag1, Tag2";

        Post testPost = new Post(-1,1,4,"https://www.wikihow.com/images/thumb/5/51/Play-Mouse-Trap-%28Board-Game%29-Step-11.jpg/aid11726718-v4-1200px-Play-Mouse-Trap-%28Board-Game%29-Step-11.jpg","test fake post","I am writing a test comment",testTags,5,true);
        System.out.println(testPost.toString());

//        // When
        HttpEntity<Post> request = new HttpEntity<>(testPost);
        ResponseEntity<Post> response1 = restTemplate.postForEntity(API_BASE_URL + "/create-post",request, Post.class);
        Post actualPost = response1.getBody();
        System.out.println(actualPost.toString());
//        Integer actualUser1 = actualFriendship.getUserIdOne();
//        Integer actualUser2 = actualFriendship.getUserIdTwo();
//
//
//
//
//        // Then
//        assertThat(response1.getStatusCode()).isEqualTo(HttpStatus.CREATED);
//        assertThat(actualUser1).isEqualTo(inputUserId1);
//        assertThat(actualUser2).isEqualTo(inputUserId2);


    }

    //    TODO  get/create friend
// create friend
    @Test
    void givenAUserIsNotFriendsWithAnotherUser_WhenTheUserSendsTheirAndTheNewFriendId_ThenTheFriendEntryIsAddedToFriendsTable() {
        // Given
        Friend newFriend3to4 = new Friend(-1,3,4);
        Integer inputUserId1 = 3;
        Integer inputUserId2 = 4;
        // When
        HttpEntity<Friend> request = new HttpEntity<>(newFriend3to4);
        ResponseEntity<Friend> response1 = restTemplate.postForEntity(API_BASE_URL + "/user/"+inputUserId1+"/add-friend",request, Friend.class);
        Friend actualFriendship = response1.getBody();
        System.out.println(actualFriendship);
        Integer actualUser1 = actualFriendship.getUserIdOne();
        Integer actualUser2 = actualFriendship.getUserIdTwo();




        // Then
        assertThat(response1.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(actualUser1).isEqualTo(inputUserId1);
        assertThat(actualUser2).isEqualTo(inputUserId2);


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
