package com.zeng.web.controller;

import com.zeng.dao.entity.User;
import com.zeng.web.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Administrator on 2016/10/6.
 */
@Controller
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @RequestMapping("/user")
    @ResponseBody
    public List<User> userAll(){
        return userService.userAll();
    }

    @RequestMapping("/adduser")
    @ResponseBody
    public boolean adduser(User user){
        boolean b=userService.addUser(user);
        return  b;
    }
    @RequestMapping("/toadd")
    public String toadd(User user){
        return "login";
    }
}
