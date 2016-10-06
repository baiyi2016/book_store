package com.zeng.web.service;

import com.zeng.dao.entity.User;

import java.util.List;

/**
 * Created by Administrator on 2016/10/6.
 */
public interface  UserServices {
    public String addUser(User user);
    public int deleteUser(Integer userId);
    public int toupdate(Integer userId);
    public String updateUser(User user);
    public List<User> userAll();
}
