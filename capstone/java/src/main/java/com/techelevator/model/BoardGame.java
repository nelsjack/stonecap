package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BoardGame {

    @JsonProperty("user_game_id")
    private int userGameId;
    @JsonProperty ("user_id")
    private int userId;
    @JsonProperty ("board_game_id")
    private String boardGameId;
    @JsonProperty ("save_type")
    private String saveType;

    public BoardGame() {
    }

    public BoardGame(int userGameId, int userId, String boardGameId, String saveType) {
        this.userGameId = userGameId;
        this.userId = userId;
        this.boardGameId = boardGameId;
        this.saveType = saveType;
    }

    public int getUserGameId() {
        return userGameId;
    }

    public void setUserGameId(int userGameId) {
        this.userGameId = userGameId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getBoardGameId() {
        return boardGameId;
    }

    public void setBoardGameId(String boardGameId) {
        this.boardGameId = boardGameId;
    }

    public String getSaveType() {
        return saveType;
    }

    public void setSaveType(String saveType) {
        this.saveType = saveType;
    }

    @Override
    public String toString() {
        return "BoardGame{" +
                "userGameId=" + userGameId +
                ", userId=" + userId +
                ", boardGameId='" + boardGameId + '\'' +
                ", saveType='" + saveType + '\'' +
                '}';
    }
}

