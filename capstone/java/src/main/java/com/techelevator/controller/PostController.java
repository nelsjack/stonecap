package com.techelevator.controller;

import com.techelevator.dao.BoardGameDao;
import com.techelevator.dao.FriendDao;
import com.techelevator.dao.PostDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Post;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class PostController {
    private PostDao postDao;
    private UserDao userDao;
    private BoardGameDao boardGameDao;
    private FriendDao friendDao;

    public PostController(PostDao postDao, UserDao userDao, BoardGameDao boardGameDao, FriendDao friendDao) {
        this.postDao = postDao;
        this.userDao = userDao;
        this.boardGameDao = boardGameDao;
        this.friendDao = friendDao;
    }

    @RequestMapping(path = "/post/{postId}", method = RequestMethod.GET)
    public Post getPost (@PathVariable int postId){
        Post post = postDao.getPost(postId);
        return post; }

    @RequestMapping(path = "/post/{boardGameId}", method = RequestMethod.GET)
    public List<Post> getAllByBoardGame(@PathVariable int boardGameId){
        List<Post> posts = postDao.getAllByBoardGame(boardGameId);
        return posts; }

    @RequestMapping(path = "/post/{userId}")
    public List<Post> getAllByUserId(int userId){
        List<Post> posts = postDao.getAllByUserId(userId);
        return posts; }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/create-post")
    public Post createNewPost(@RequestBody Post createPost){
        return postDao.createNewPost(createPost); }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(path = "/delete-post", method = RequestMethod.DELETE)
    public void deletePost(@PathVariable int postId){
        postDao.deletePost(postId);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(path = "/delete-image", method = RequestMethod.DELETE)
    public void deleteImage(String imageUrl){
        postDao.deleteImage(imageUrl);
    }

}
