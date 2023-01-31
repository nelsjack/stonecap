package com.techelevator.dao;

import com.techelevator.model.Post;

import java.util.List;

public interface PostDao {
    List<Post> getAllByBoardGame(int boardGameId);
    List<Post> getAllByUserId(int userId);
    Post createPost(int rating, String title, List<String> tags, String comments, String imageUrl, boolean publicPrivate);
    Post updatePost(int postId);
    Post deletePost(int postId);
    Post deleteImage(String imageUrl);
    Post updateTitle(String title);
    Post updateRating(int rating);


}
