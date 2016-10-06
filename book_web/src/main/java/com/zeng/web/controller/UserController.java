package com.zeng.web.controller;

import com.zeng.dao.entity.User;
import com.zeng.web.service.impl.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Administrator on 2016/10/6.
 */
@Controller
public class UserController {
    private UserServiceImpl userService;
    @RequestMapping("/user")
    @ResponseBody
    public List<User> userAll(){
        return userService.userAll();
    }
}
