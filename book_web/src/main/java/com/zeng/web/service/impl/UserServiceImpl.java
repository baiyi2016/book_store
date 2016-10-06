package com.zeng.web.service.impl;

import com.zeng.dao.entity.User;
import com.zeng.dao.mapper.UserMapper;
import com.zeng.web.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/10/6.
 */
@Service
public class UserServiceImpl implements UserServices{
    @Autowired
    private UserMapper userMapper;

    @Override
    public String addUser(User user) {
        return null;
    }

    @Override
    public int deleteUser(Integer userId) {
        return 0;
    }

    @Override
    public int toupdate(Integer userId) {
        return 0;
    }

    @Override
    public String updateUser(User user) {
        return null;
    }

    @Override
    public List<User> userAll() {
        return userMapper.searchUserByParams(null);
    }
}
