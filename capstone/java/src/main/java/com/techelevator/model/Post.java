package com.techelevator.model;

import java.util.List;

public class Post {
    private int postId;
    private int userId;
    private int userGameId;
    private String imageUrl;
    private String title;
    private String comments;
    private String tags;
    private int rating;
    private boolean publicPrivate;

    public Post() {
    }

    public Post(int postId, int userId, int userGameId, String imageUrl, String title, String comments, String tags, int rating, boolean publicPrivate) {
        this.postId = postId;
        this.userId = userId;
        this.userGameId = userGameId;
        this.imageUrl = imageUrl;
        this.title = title;
        this.comments = comments;
        this.tags = tags;
        this.rating = rating;
        this.publicPrivate = publicPrivate;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUserGameId() {
        return userGameId;
    }

    public void setUserGameId(int userGameId) {
        this.userGameId = userGameId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public boolean isPublicPrivate() {
        return publicPrivate;
    }

    public void setPublicPrivate(boolean publicPrivate) {
        this.publicPrivate = publicPrivate;
    }

    @Override
    public String toString() {
        return "Post{" +
                "postId=" + postId +
                ", userId=" + userId +
                ", userGameId=" + userGameId +
                ", imageUrl='" + imageUrl + '\'' +
                ", title='" + title + '\'' +
                ", comments='" + comments + '\'' +
                ", tags=" + tags +
                ", rating=" + rating +
                ", publicPrivate=" + publicPrivate +
                '}';
    }
}
