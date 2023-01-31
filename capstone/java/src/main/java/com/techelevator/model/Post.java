package com.techelevator.model;

import java.util.List;

public class Post {
    private int rating;
    private String title;
    private List<String> tags;
    private String comments;
    private String imageUrl;
    private boolean publicPrivate;

    public Post() {
    }

    public Post(int rating, String title, List<String> tags, String comments, String imageUrl, boolean publicPrivate) {
        this.rating = rating;
        this.title = title;
        this.tags = tags;
        this.comments = comments;
        this.imageUrl = imageUrl;
        this.publicPrivate = publicPrivate;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public boolean isPublicPrivate() {
        return publicPrivate;
    }

    public void setPublicPrivate(boolean publicPrivate) {
        this.publicPrivate = publicPrivate;
    }
}
