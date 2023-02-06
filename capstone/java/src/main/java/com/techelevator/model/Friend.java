package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Friend {
    @JsonProperty ("friend_id")
    private int friendshipId;
    @JsonProperty ("user_id_one")
    private int userIdOne;
    @JsonProperty ("user_id_two")
    private int userIdTwo;

    public Friend() {
    }

    public Friend(int friendshipId, int userIdOne, int userIdTwo) {
        this.friendshipId = friendshipId;
        this.userIdOne = userIdOne;
        this.userIdTwo = userIdTwo;
    }


    public int getFriendshipId() {
        return friendshipId;
    }

    public void setFriendshipId(int friendshipId) {
        this.friendshipId = friendshipId;
    }

    public int getUserIdOne() {
        return userIdOne;
    }

    public void setUserIdOne(int userIdOne) {
        this.userIdOne = userIdOne;
    }

    public int getUserIdTwo() {
        return userIdTwo;
    }

    public void setUserIdTwo(int userIdTwo) {
        this.userIdTwo = userIdTwo;
    }

    @Override
    public String toString() {
        return "Friend{" +
                "friendshipId=" + friendshipId +
                ", userIdOne=" + userIdOne +
                ", userIdTwo=" + userIdTwo +
                '}';
    }
}
