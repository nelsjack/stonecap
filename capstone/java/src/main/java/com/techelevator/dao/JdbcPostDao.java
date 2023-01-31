package com.techelevator.dao;

import com.techelevator.model.Post;

import java.util.List;

public class JdbcPostDao implements PostDao{

    public List<Post> getAllByBoardGame(int boardGameId) {
        return null;
    }
    public List<Post> getAllByUserId(int userId){
        return null;
    }

    public Post createPost(int rating, String title, List<String> tags, String comments, String imageUrl, boolean publicPrivate) {
        return null;
    }

    public Post updatePost(int postId) {return null; }
    public Post deletePost(int postId) {return null; }
    public Post deleteImage(String imageUrl){return null; }
    public Post updateTitle(String title) {return null; }
    public Post updateRating(int rating) {return null; }
}
