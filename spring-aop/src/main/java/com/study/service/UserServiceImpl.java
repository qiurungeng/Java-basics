package com.study.service;

public class UserServiceImpl implements UserService {
    @Override
    public String add() {
        System.out.println("增加了一个用户");
        return "string";
    }

    @Override
    public void delete() {
        System.out.println("删除了一个用户");
    }

    @Override
    public void update() {
        System.out.println("修改了一个用户");
    }

    @Override
    public void select() {
        System.out.println("找到了一个用户");
    }
}
