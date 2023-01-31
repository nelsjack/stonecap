package com.techelevator.controller;

import com.techelevator.dao.BoardGameDao;
import com.techelevator.dao.FriendDao;
import com.techelevator.dao.PostDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.BoardGame;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RestController;

@RestController
@PreAuthorize("isAuthenticated")
public class UserController {
    private UserDao userDao;
    private BoardGameDao boardGameDao;
    private FriendDao friendDao;
    private PostDao postDao;
    private String path = "/user";

    public UserController(UserDao userDao, BoardGameDao boardGameDao, FriendDao friendDao, PostDao postDao) {
        this.userDao = userDao;
        this.boardGameDao = boardGameDao;
        this.friendDao = friendDao;
        this.postDao = postDao;
    }

    




    /*
     * get all users      /user/allUser          XX
     * get all friends        /user/{username}/friends      XX
     * post friends (add)    /user/{username}/add-friend       XX
     * delete friends          /user/{username}/update-friends     XX
      * users by board game /user/boardgame/{boardgameid}
     * */
}
