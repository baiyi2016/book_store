package com.zeng.web.service.impl;

import com.zeng.dao.entity.User;
import com.zeng.dao.mapper.UserMapper;
import com.zeng.web.service.UserServices;
import org.apache.ibatis.annotations.Param;
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
    public boolean addUser(User user) {
        userMapper.insertUser(user);
        return true;
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

    @Override
    public User find(@Param("username") String username, @Param("password") String password) {
        Map<String,String> map = new HashMap<String,String>();
        map.put("username",username);
        map.put("password",password);
        List<User> list =  userMapper.searchUserByParams(map);
        if(list!=null&&list.size()==1) {
            return list.get(0);
        }
        return null;
    }
}
