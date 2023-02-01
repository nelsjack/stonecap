package com.techelevator.controller;

import com.techelevator.dao.BoardGameDao;
import com.techelevator.dao.FriendDao;
import com.techelevator.dao.PostDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.BoardGame;
import com.techelevator.model.Friend;
import com.techelevator.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.lang.UsesSunHttpServer;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@RestController
@PreAuthorize("isAuthenticated")
public class UserController {
    private UserDao userDao;
    private BoardGameDao boardGameDao;
    private FriendDao friendDao;
    private PostDao postDao;
    //private String path = "/user";

    public UserController(UserDao userDao, BoardGameDao boardGameDao, FriendDao friendDao, PostDao postDao) {
        this.userDao = userDao;
        this.boardGameDao = boardGameDao;
        this.friendDao = friendDao;
        this.postDao = postDao;
    }

    @RequestMapping(path = "/all-users", method = RequestMethod.GET)
    public List<String> findAll() {
        List<String> usernames = new ArrayList<>();
        List<User> users = userDao.findAll();
        for (User user: users) {
            usernames.add(user.getUsername());
        }
        return usernames;
    }

    @RequestMapping(path = "/user/{id}", method = RequestMethod.GET)
    public User getUserById(@PathVariable int userId) {
        User user = userDao.getUserById(userId);
        return user;
    }

    @RequestMapping(path = "/user/{username}/friends", method = RequestMethod.GET)
    public List<Integer> findAllFriendsById(@PathVariable int userId){
        List<Integer> friendsUserIds = new ArrayList<>();
        List<Friend> friends = friendDao.findAllFriendsById(userId);
        for (Friend friend : friends) {
            friendsUserIds.add(friend.getUserIdTwo());
        }
        return friendsUserIds;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/user/{username}/add-friend")
    public Friend createFriendship(@RequestBody Friend newFriend){
        return friendDao.createFriendship(newFriend);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(path = "/user/{username}/remove-friend", method = RequestMethod.DELETE)
    public void deleteFriend(@PathVariable int userId){
        friendDao.deleteFriend(userId);
    }

    @RequestMapping(path = "/user/boardgame/{boardgameId}")
    public List<String> usersByBoardGame(@PathVariable String boardGameId){
        List<String> users = new ArrayList<>();
        List<User> getUsersByBoardGame = userDao.usersByBoardGame(boardGameId);
        for(User user : getUsersByBoardGame) {
            users.add(user.getUsername());
        }
        return users;
    }




    /*
     * get all users      /user/allUsers          XX
     * get all friends        /user/{username}/friends      XX
     * post friends (add)    /user/{username}/add-friend       XX
     * delete friends          /user/{username}/remove-friend/{userId}    XX
      * users by board game /user/boardgame/{boardgameid}
     * */
}
