package com.techelevator.dao;

import com.techelevator.model.BoardGame;
import com.techelevator.model.User;

import java.util.List;

public interface BoardGameDao {

    //List<User> usersByBoardGame(int boardGameId);
    List<BoardGame> wishlistBoardGameByUserId(int userId, String saveType);
    List<BoardGame> playedBoardGamesByUserId(int userId, String saveType);
    boolean saveGameForUser(int userId);
}
