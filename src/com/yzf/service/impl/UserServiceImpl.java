package com.yzf.service.impl;

import com.yzf.dao.UserDao;
import com.yzf.dao.impl.UserDaoImpl;
import com.yzf.pojo.User;
import com.yzf.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();
    @Override
    public void registUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User login(User user) {
        return userDao.queryUserByUsernameAndPassword(user.getUsername(),user.getPassword());
    }

    @Override

    public boolean existsUsername(String username) {
        if(userDao.queryUserByUsername(username)==null){
            return false;
        }
        else return true;
    }
}
