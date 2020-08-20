package com.study.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insert(){
        String sql="INSERT INTO tbl_user(username,age) VALUES (?,?);";
        String uid = UUID.randomUUID().toString().substring(0, 5);
        jdbcTemplate.update(sql,uid,19);
    }
}
