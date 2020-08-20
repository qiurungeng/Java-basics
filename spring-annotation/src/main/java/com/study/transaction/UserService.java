package com.study.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

@EnableTransactionManagement
@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    @Transactional
    public void insertUser(){
        userDao.insert();
        System.out.println("插入数据完成");
        int i=10/0;
    }
}
