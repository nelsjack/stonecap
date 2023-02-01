package com.techelevator.service;

import com.techelevator.model.BoardGame;
import org.apache.catalina.LifecycleState;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class BoardGameServices {

    public static String API_BASE_URL = "https://api.boardgameatlas.com/api/search?order_by=rank&ascending=false&pretty=true&client_id=kYNboY2Iyu";
    private RestTemplate restTemplate = new RestTemplate();

// button w/All Board Games
    public BoardGame[] getAllBoardGames(){
        BoardGame[] boardGamesFromApi = restTemplate.getForObject(API_BASE_URL, BoardGame [].class);
        return boardGamesFromApi;
    }

//    text box - search (name, year, number)
    public BoardGame getBoardGame(String name) {
        BoardGame boardGameFromApi = restTemplate.getForObject(API_BASE_URL + name, BoardGame.class );
        return boardGameFromApi;
    }

//    public BoardGame getBoardGameByYear (int year) {
//        BoardGame boardGameFromApi = restTemplate.getForObject(API_BASE_URL + year, BoardGame.class );
//        return boardGameFromApi;
//    }
//
//    public BoardGame getBoardGameByPlayers (int players) {
//        BoardGame boardGameFromApi = restTemplate.getForObject(API_BASE_URL + players, BoardGame.class );
//        return boardGameFromApi;
//    }

    public BoardGame[] getAllBoardGames (List<Integer> boardGameIdList) {
        BoardGame[] userBoardGamesFromApi = restTemplate.getForObject(API_BASE_URL + boardGameIdList, BoardGame [].class);
        return userBoardGamesFromApi;
    }
/*
    get all                     XX
    get by name                 XX
    get by year                 XX
    get by num of players       XX
    get all by user id          XX
 */
}
