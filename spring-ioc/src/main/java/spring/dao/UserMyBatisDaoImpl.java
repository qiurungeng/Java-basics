package spring.dao;

public class UserMyBatisDaoImpl implements UserDao{

    @Override
    public String getUser() {
        return "UserMyBatisDaoImpl,mybatis方式获取用户数据";
    }
}
