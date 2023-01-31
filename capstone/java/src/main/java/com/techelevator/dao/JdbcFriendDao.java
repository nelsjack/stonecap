package com.techelevator.dao;

import com.techelevator.model.Friend;
import com.techelevator.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcFriendDao implements FriendDao{
    private JdbcTemplate jdbcTemplate;

    public JdbcFriendDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Friend getFriend(int userId){
        Friend friend = null;
        String sql = "SELECT * from friends WHERE user_id_two = ?";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, userId);
        if(result.next()){
            friend = mapToRowSet(result);
        }
        return friend;
    }

    public List<Friend> findAllFriendsById(int userId) {
        List<Friend> friends = new ArrayList<>();
        String sql = "SELECT * FROM friends WHERE user_id_one = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);

        while(results.next()) {
             Friend friend = mapToRowSet(results);
            friends.add(friend);
        }
        return friends;
    }

    public Friend createFriendship(Friend newFriend){
        Friend friendship = null;
        String sql = "INSERT INTO friends (user_id_one, user_id_two) VALUES (?, ?) RETURNING friend_id";
        Integer newFriendshipId = jdbcTemplate.queryForObject(sql, int.class, newFriend.getUserIdOne(), newFriend.getUserIdTwo());
        friendship = getFriend(newFriendshipId);

        return friendship;
    }

    public void deleteFriend(int userId){
        String sql = "DELETE FROM friends WHERE user_id_two = ?";
        jdbcTemplate.update(sql, userId);
    }

    private Friend mapToRowSet(SqlRowSet rs) {
        Friend friend = new Friend();
        friend.setFriendshipId(rs.getInt("friend_id"));
        friend.setUserIdOne(rs.getInt("user_id_one"));
        friend.setUserIdTwo(rs.getInt("user_id_two"));
        return friend;
    }
}
