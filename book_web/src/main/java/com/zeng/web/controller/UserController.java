package com.zeng.web.controller;

import com.zeng.dao.entity.User;
import com.zeng.web.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Administrator on 2016/10/6.
 */
@Controller
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    //查询数据库所有信息
    @RequestMapping("/user")
    @ResponseBody
    public List<User> userAll(){
        return userService.userAll();
    }

    //登录查询数据库功能
    @RequestMapping("/getuser")
    @ResponseBody
    public boolean getuser(@RequestParam("username")String username,@RequestParam("password")String password,HttpSession session){
        User user = userService.find(username, password);
        if(user!=null) {
            session.setAttribute("user",user);
            return true;
        }
      return false;
    }
    //跳转首页
    @RequestMapping("/toindex")
    public String toindex(){
        return "index";
    }

    //注册 增加功能
    @RequestMapping("/adduser")
    @ResponseBody
    public boolean adduser(User user){
        boolean b=userService.addUser(user);
        return  b;
    }
    //跳到注册界面
    @RequestMapping("/toadd")
    public String toadd(User user){
        return "register";
    }

    //登录和注册界面
    @RequestMapping("/tologin")
    public String tologin(){
        return "login";
    }

    //跳转注册成功页面
    @RequestMapping("/toregister")
    public String toregister(){
        return "redirect:/register_success.html";
    }
}
