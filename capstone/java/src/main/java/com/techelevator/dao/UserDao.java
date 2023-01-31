package com.techelevator.dao;

import com.techelevator.model.User;

import java.util.List;

public interface UserDao {

    List<User> findAll();

    User getUserById(int userId);

    User findByUsername(String username);

    int findIdByUsername(String username);

    boolean create(String username, String password, String role);

    List<User> findAllFriendsById(int userId);

    boolean saveFriend(String username, int userId);

    boolean deleteFriend(String username, int userId);

}
