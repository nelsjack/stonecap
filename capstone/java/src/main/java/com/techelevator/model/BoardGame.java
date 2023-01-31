package com.techelevator.model;

public class BoardGame {

    private String gameName;
    private String description;
    private int numPlayers; //counter of saved 'players'
    private String image;
    private String publishedDate;

    public BoardGame() {
    }

    public BoardGame(String gameName, String description, int numPlayers, String image, String publishedDate) {
        this.gameName = gameName;
        this.description = description;
        this.numPlayers = numPlayers;
        this.image = image;
        this.publishedDate = publishedDate;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNumPlayers() {
        return numPlayers;
    }

    public void setNumPlayers(int numPlayers) {
        this.numPlayers = numPlayers;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    @Override
    public String toString() {
        return "BoardGame{" +
                "gameName='" + gameName + '\'' +
                ", description='" + description + '\'' +
                ", numPlayers=" + numPlayers +
                ", image='" + image + '\'' +
                ", publishedDate='" + publishedDate + '\'' +
                '}';
    }
}

