package com.techelevator.dao;

import com.techelevator.model.BoardGame;
import com.techelevator.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;
import java.util.List;

public class JdbcBoardGameDao implements BoardGameDao {
    private JdbcTemplate jdbcTemplate;

    public JdbcBoardGameDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //todo: move to users?
//    public List<User> usersByBoardGame(int boardGameId){
//        List<User> users = new ArrayList<>();
//        String sql = "SELECT user_id FROM boardgames WHERE boardgame_id = ?";
//        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, boardGameId);
//
//        while(results.next()){
//            User user = mapRowToBoardGame(results);
//            users.add(user);
//        }
//        return users;
//    }

    

    //todo: confirm sql syntax
    public List<BoardGame> wishlistBoardGameByUserId(int userId, String saveType){
        List<BoardGame> wishlistGames = new ArrayList<>();
        String sql = "SELECT boardgame_id FROM boardgames WHERE user_id = ? AND save_type = ? ";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId, saveType);

        while(results.next())
        {
            BoardGame game = mapRowToBoardGame(results);
            wishlistGames.add(game);
        }
        return wishlistGames;
    }

    //todo: confirm sql syntax
    public List<BoardGame> playedBoardGamesByUserId(int userId, String saveType){
        List<BoardGame> playedGames = new ArrayList<>();
        String sql = "SELECT boardgame_id FROM boardgames WHERE user_id = ? AND save_type = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId, saveType);

        while(results.next()) {
            BoardGame game = mapRowToBoardGame(results);
            playedGames.add(game);
        }
        return playedGames;
    }

    //todo: confirm sql syntax
    public BoardGame saveGameForUser(BoardGame saveGame) {
        BoardGame savedGames = null;
        String sql = "INSERT INTO boardgames (user_id, boardgame_id, save_type) VALUES (?, ?, ?)";
        Integer userGameId = jdbcTemplate.queryForObject(sql, Integer.class, saveGame.getUserId(), saveGame.getBoardGameId(), saveGame.getSaveType());
        savedGames =
        return;
    }

    private BoardGame mapRowToBoardGame (SqlRowSet rs) {
        BoardGame boardGame = new BoardGame();
        boardGame.setUserGameId(rs.getInt("user_game_id"));
        boardGame.setUserId(rs.getInt("user_id"));
        boardGame.setBoardGameId(rs.getString("boardgame_id"));
        boardGame.setSaveType(rs.getString("save_type"));
        return boardGame;
    }

}
