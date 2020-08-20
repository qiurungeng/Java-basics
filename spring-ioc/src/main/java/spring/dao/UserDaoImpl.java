package spring.dao;

public class UserDaoImpl implements UserDao {
    @Override
    public String getUser() {
        return "userDaoImpl，JDBC方式获取用户数据";
    }
}
