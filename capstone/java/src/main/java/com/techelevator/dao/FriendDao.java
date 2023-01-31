package com.techelevator.dao;

import com.techelevator.model.Friend;
import com.techelevator.model.User;

import java.util.List;

public interface FriendDao {

    List<Friend> findAllFriendsById(int userId);

    Friend createFriendship(Friend newFriend);

    boolean deleteFriend(int userId);

}
