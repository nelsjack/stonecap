package com.techelevator.controller;

import com.techelevator.dao.BoardGameDao;
import com.techelevator.dao.FriendDao;
import com.techelevator.dao.PostDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Post;

import java.util.List;

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

    public Post getPost (int postId){return null; }
    public List<Post> getAllByBoardGame(int boardGameId){return null; }
    public List<Post> getAllByUserId(int userId){return null; }
    public Post createNewPost(Post createPost){return null; }
    public void deletePost(int postId){}
    public void deleteImage(String imageUrl){}

    /*
     * get all posts
     * post a post
     * put post
     * delete post
     * delete picture
     * put title of the post
     * delete title of the post
     * put rating
     * delete rating
    * */

}
