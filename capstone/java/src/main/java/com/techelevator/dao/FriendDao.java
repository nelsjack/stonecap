package com.techelevator.dao;

import com.techelevator.model.User;

import java.util.List;

public interface FriendDao {

    List<User> findAllFriendsById(int userId);

    boolean saveFriend(String username, int userId);

    boolean deleteFriend(String username, int userId);

}
