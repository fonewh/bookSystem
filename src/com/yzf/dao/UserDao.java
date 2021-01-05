package com.yzf.dao;

import com.yzf.pojo.User;

public interface UserDao {

    public User queryUserByUsername(String username);
    public User queryUserByUsernameAndPassword(String username,String password);
    public int saveUser(User user);
}
