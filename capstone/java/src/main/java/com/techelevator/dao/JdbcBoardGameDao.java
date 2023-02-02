package com.techelevator.dao;

import com.techelevator.model.BoardGame;
import com.techelevator.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcBoardGameDao implements BoardGameDao {
    private JdbcTemplate jdbcTemplate;

    public JdbcBoardGameDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }



    public BoardGame getBoardGame(String boardGameId){
        BoardGame game = null;
        String sql = "SELECT * FROM boardgames WHERE board_game_id = ?";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, boardGameId);

        if(result.next()) {
            game = mapRowToBoardGame(result);
        }
        return game;
    }

    //todo: confirm sql syntax
    public List<BoardGame> wishlistBoardGameByUserId(int userId, String saveType){
        List<BoardGame> wishlistGames = new ArrayList<>();
        String sql = "SELECT board_game_id FROM boardgames WHERE user_id = ? AND save_type = ? ";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId, saveType);

        while(results.next())
        {
            BoardGame game = mapRowToBoardGame(results);
            wishlistGames.add(game);
        }
        return wishlistGames;
    }

    //todo: confirm sql syntax
    @Override
    public List<BoardGame> playedBoardGamesByUserId(int userId, String saveType){
        List<BoardGame> playedGames = new ArrayList<>();
        String sql = "SELECT user_game_id, user_id, board_game_id, save_type FROM boardgames WHERE user_id = ? AND save_type = ?";
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
        String sql = "INSERT INTO boardgames (user_id, board_game_id, save_type) VALUES (?, ?, ?)";
        Integer userGameId = jdbcTemplate.queryForObject(sql, Integer.class, saveGame.getUserId(), saveGame.getBoardGameId(), saveGame.getSaveType());
        savedGames = getBoardGame(String.valueOf(userGameId));
        return savedGames;
    }

    public void removeBoardGame(int userId, String boardGameId){
        String sql = "DELETE FROM boardgames WHERE user_id = ? AND board_game_id = ?";
        jdbcTemplate.update(sql, userId, boardGameId);
    }

    private BoardGame mapRowToBoardGame (SqlRowSet rs) {
        BoardGame boardGame = new BoardGame();
        boardGame.setUserGameId(rs.getInt("user_game_id"));
        boardGame.setUserId(rs.getInt("user_id"));
        boardGame.setBoardGameId(rs.getString("board_game_id"));
        boardGame.setSaveType(rs.getString("save_type"));
        return boardGame;
    }

}
