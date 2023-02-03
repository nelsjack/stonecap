package com.techelevator.dao;

import com.techelevator.model.Post;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcPostDao implements PostDao{
    private JdbcTemplate jdbcTemplate;

    public JdbcPostDao (JdbcTemplate jdbcTemplate){ this.jdbcTemplate = jdbcTemplate; }

   public Post getPost (int postId){
        Post post = null;
        String sql = "SELECT * FROM posts WHERE post_id = ?";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, postId);
        if(result.next()){
            post = mapRowToPost(result);
        }
        return post;
   }

//    public List<Post> getAllByBoardGame(int boardGameId) {
//        List<Post> postsByBoardGame = new ArrayList<>();
//        String sql = "SELECT * FROM posts WHERE user_game_id IN (SELECT user_game_id FROM boardgames WHERE boardgame_id = ?";
//        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, boardGameId);
//        while(results.next()){
//            Post post = mapRowToPost(results);
//            postsByBoardGame.add(post);
//        }
//        return postsByBoardGame;
//    }

    public List<Post> getAllByUserId(int userId){
        List<Post> postsByUser = new ArrayList<>();
        String sql = "SELECT * FROM posts WHERE user_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
        while(results.next()){
            Post post = mapRowToPost(results);
            postsByUser.add(post);
        }
        return postsByUser;
    }

    public Post createNewPost(Post createPost) {
        Post newPost = null;
//        TODO check the names of the columns in insert SQL
        String sql = "INSERT INTO posts (image, title, comments, tags, rating, public_private) VALUES (?, ?, ?, ?, ?, ?) RETURNING post_id";
        Integer postId = jdbcTemplate.queryForObject(sql, Integer.class, createPost.getImageUrl(), createPost.getTitle(), createPost.getComments(), createPost.getTags(), createPost.getRating(), createPost.isPublicPrivate());
        newPost = getPost(postId);
        return newPost;
    }

    public void deletePost(int postId) {
        String sql = "DELETE FROM posts WHERE post_id = ?";
        jdbcTemplate.update(sql, postId);
    }

    //todo: if we just want to delete photo should we have just a image class/database
    public void deleteImage(String imageUrl){

        String sql = "DELETE FROM posts WHERE ";
    }

    public void updatePost (Post updatePost){
        String sql = "UPDATE posts SET title = ?, comments = ?, tags = ?, rating = ? WHERE post_id = ?";
        jdbcTemplate.update(sql, updatePost.getTitle(), updatePost.getComments(), updatePost.getTags(), updatePost.getRating(), updatePost.getPostId());
    }

    private Post mapRowToPost (SqlRowSet rs){
        Post post = new Post();
        post.setPostId(rs.getInt("post_id"));
        post.setUserId(rs.getInt("user_id"));
//        post.setUserGameId(rs.getInt("user_game_id"));
        post.setImageUrl(rs.getString("image"));
        post.setTitle(rs.getString("title"));
        post.setComments(rs.getString("comments"));
        post.setTags((List<String>) rs.getObject("tags"));
        post.setRating(rs.getInt("rating"));
        post.setPublicPrivate(rs.getBoolean("public_private"));
        return post;
    }
}
