package com.yzf.test;

import com.yzf.dao.UserDao;
import com.yzf.dao.impl.UserDaoImpl;
import com.yzf.pojo.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserDaoTest {
    UserDao userDao = new UserDaoImpl();

    @Test
    public void queryUserByUsername() {

        if(userDao.queryUserByUsername("admin")==null){
            System.out.println("用户名可用！");
        }
        else System.out.println("用户名已存在");
    }

    @Test
    public void queryUserByUsernameAndPassword() {
        if(userDao.queryUserByUsernameAndPassword("admin","admin")==null){
            System.out.println("账户名或密码错误");
        }
        else System.out.println("登录成功");

    }

    @Test
    public void saveUser() {
        User user = new User(001,"yaozefan","wsad0524","940163517@qq.com");
        if(userDao.queryUserByUsername(user.getUsername())==null){
            userDao.saveUser(user);
            System.out.println("注册成功");
        }
        else System.out.println("用户名已存在,不可注册");

    }
}