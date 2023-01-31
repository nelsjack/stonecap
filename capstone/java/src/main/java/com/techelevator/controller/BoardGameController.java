package com.techelevator.controller;

import com.techelevator.dao.BoardGameDao;
import com.techelevator.dao.FriendDao;
import com.techelevator.dao.PostDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.BoardGame;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class BoardGameController {

    private BoardGameDao boardGameDao;
    private FriendDao friendDao;
    private PostDao postDao;
    private UserDao userDao;

    public BoardGameController(BoardGameDao boardGameDao, FriendDao friendDao, PostDao postDao, UserDao userDao) {
        this.boardGameDao = boardGameDao;
        this.friendDao = friendDao;
        this.postDao = postDao;
        this.userDao = userDao;
    }

    public BoardGame getBoardGame (String boardGameId){
        return null;
    }
    public List<BoardGame> wishlistBoardGameByUserId(int userId, String saveType) {
       return null;
    }

    @RequestMapping(path = "/boardgame/{username}", method = RequestMethod.GET)
    public List<BoardGame> playedBoardGamesByUsername(@PathVariable String username) {
        int userId = userDao.findIdByUsername(username);
        List<BoardGame> playedGames = boardGameDao.playedBoardGamesByUserId(userId, "played");
        return playedGames;
    }
    public BoardGame saveGameForUser(BoardGame saveGame) {
        return null;
    }

    /*
    *  get all (in the api services)
    *  search bys (in the api services)
    *  get users by board game id
     * get wishlist board games
     * get played board games <>
     * post wishlist board game
     * post played board game
     * delete board games
    * */

}
