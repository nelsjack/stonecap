package com.techelevator.dao;

import com.techelevator.model.User;

import java.util.List;

public interface UserDao {

    List<User> findAll();

    User getUserById(int userId);

    User findByUsername(String username);

    int findIdByUsername(String username);

    List<User> findByUsernameContains(String username);

    boolean create(String username, String password, String role);

    List<User> usersByBoardGame (String boardGameId);

}
