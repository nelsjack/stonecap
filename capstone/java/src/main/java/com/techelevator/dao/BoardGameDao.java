package com.techelevator.dao;

import com.techelevator.model.BoardGame;
import com.techelevator.model.User;

import java.util.List;

public interface BoardGameDao {

    List<User> usersByBoardGame(int boardGameId);
    List<BoardGame> wishlistBoardGameByUserId(int userId);
    List<BoardGame> playedBoardGamesByUserId(int userId);
    boolean saveToWishList();
    boolean saveToPlayed();
    boolean deleteBoardGame();

}
