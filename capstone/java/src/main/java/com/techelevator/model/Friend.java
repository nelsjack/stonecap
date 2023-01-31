package com.techelevator.model;

public class Friend {
    private int friendshipId;
    private int userIdOne;
    private String usernameOne;
    private int userIdTwo;
    private String usernameTwo;

    public Friend() {
    }

    public Friend(int friendshipId, int userIdOne, String usernameOne, int userIdTwo, String usernameTwo) {
        this.friendshipId = friendshipId;
        this.userIdOne = userIdOne;
        this.usernameOne = usernameOne;
        this.userIdTwo = userIdTwo;
        this.usernameTwo = usernameTwo;
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

    public String getUsernameOne() {
        return usernameOne;
    }

    public void setUsernameOne(String usernameOne) {
        this.usernameOne = usernameOne;
    }

    public int getUserIdTwo() {
        return userIdTwo;
    }

    public void setUserIdTwo(int userIdTwo) {
        this.userIdTwo = userIdTwo;
    }

    public String getUsernameTwo() {
        return usernameTwo;
    }

    public void setUsernameTwo(String usernameTwo) {
        this.usernameTwo = usernameTwo;
    }

    @Override
    public String toString() {
        return "Friend{" +
                "friendshipId=" + friendshipId +
                ", userIdOne=" + userIdOne +
                ", usernameOne='" + usernameOne + '\'' +
                ", userIdTwo=" + userIdTwo +
                ", usernameTwo='" + usernameTwo + '\'' +
                '}';
    }
}
