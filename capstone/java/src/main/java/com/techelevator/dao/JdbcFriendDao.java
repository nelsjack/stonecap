package com.techelevator.dao;

import com.techelevator.model.User;

import java.util.List;

public class JdbcFriendDao implements FriendDao{

    public List<User> findAllFriendsById(int userId) {
        return null;
    }

    public boolean saveFriend(String username, int userId){
        return false;
    }

    public boolean deleteFriend(String username, int userId){
        return false;
    }
}
