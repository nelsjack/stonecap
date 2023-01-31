package com.techelevator.dao;

import com.techelevator.model.Post;
import org.springframework.jdbc.support.rowset.SqlRowSet;

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

    //todo: come back to this
    private Post mapRowToPost (SqlRowSet rs){
        Post post = new Post();
        post.setPostId(rs.getInt("post_id"));
        post.setUserId(rs.getInt("user_id"));
        post.setUserGameId(rs.getInt("user_game_id"));
        post.setImageUrl(rs.getString("image"));
        post.setTitle(rs.getString("title"));
        post.setComments(rs.getString("comments"));
        post.setTags((List<String>) rs.getObject("tags"));

        return post;
    }
}
