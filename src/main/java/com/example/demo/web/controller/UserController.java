package com.example.demo.web.controller;

import com.example.demo.dao.UserDao;
import com.example.demo.dto.User;
import com.example.demo.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.constraints.Size;
import java.util.List;

public class UserController {
    @Autowired
    UserDao userDao;

    @Autowired
    User user;

    @RequestMapping("/")
    public String index(Model model){
        List<User> user = userDao.selectAll();
        //modelへ詰める
        model.addAttribute("user",user);
        //templates/user/index.htmlへ遷移
        return "user/index";
    }
}
