package spring.service;

import spring.dao.UserDao;

public class UserServiceImpl implements UserService {

    private UserDao userDao;
    /************************************************************
     * 控制反转，不再由Service自身提供Dao实现，而由调用Service的人提供Dao
     * 不再由餐厅自己预备食材，而由顾客带食材来给餐厅加工。
     * 利用set实现动态注入
     */
    public void setUserDao(UserDao userDao){
        this.userDao=userDao;
    }


    @Override
    public String getUser() {
        return userDao.getUser();
    }
}
