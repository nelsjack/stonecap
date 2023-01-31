package com.techelevator.dao;

import com.techelevator.model.Post;

import java.util.List;

public interface PostDao {
    List<Post> getAllByBoardGame(int boardGameId);
    List<Post> getAllByUserId(int userId);
    Post createNewPost(Post createPost);
    Post updatePost(int postId);
    void deletePost(int postId);
    void deleteImage(String imageUrl);
    void updatePost(Post updatePost);


}
