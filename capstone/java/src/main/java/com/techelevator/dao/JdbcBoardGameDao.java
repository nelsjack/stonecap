package com.techelevator.dao;

import com.techelevator.model.BoardGame;
import com.techelevator.model.User;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.List;

public class JdbcBoardGameDao implements BoardGameDao {

    public List<User> usersByBoardGame(int boardGameId){return null; }
    public List<BoardGame> wishlistBoardGameByUserId(int userId){return null; }
    public List<BoardGame> playedBoardGamesByUserId(int userId){return null; }
    public boolean saveToWishList(){return false; }
    public boolean saveToPlayed(){return false; }
    public boolean deleteBoardGame(){return false; }


    private BoardGame mapRowToBoardGame (SqlRowSet rs) {
        BoardGame boardGame = new BoardGame();
        boardGame.set

        return boardGame;
    }

}
