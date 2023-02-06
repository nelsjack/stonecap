package com.techelevator.dao;

import com.techelevator.model.Post;

import java.util.List;

public interface PostDao {
    Post getPost (int postId);
//    List<Post> getAllByBoardGame(int boardGameId);
    List<Post> getAllByUserId(int userId);
    Post createNewPost(Post createPost);
    void deletePost(int postId);
    void deleteImage(String imageUrl);
}
