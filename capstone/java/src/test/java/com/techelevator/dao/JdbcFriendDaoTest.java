package com.techelevator.dao;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.junit.jupiter.api.Assertions.*;

class JdbcFriendDaoTest extends BaseDaoTests {
private JdbcFriendDao sut;
    @Before
    public void setup() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        sut = new JdbcFriendDao(jdbcTemplate);
    }
    @Test
    void givenAPostIdWhenGetFriendThenReturnsPost() {
        sut.getFriend(1);
    }

}