package com.example.demo.web.controller;

import com.example.demo.dao.UserDao;
import com.example.demo.dto.User;
import com.example.demo.service.UserServiceImpl;
import com.example.demo.web.form.UserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.constraints.Size;
import java.util.List;

@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    UserDao userDao;

    @ModelAttribute
    UserForm setupForm(){return new UserForm();}

    @GetMapping("/index")
    public String index(Model model){
        List<User> user = userDao.selectAll();
        //modelへ詰める
        model.addAttribute("user",user);
        //templates/user/index.htmlへ遷移
        return "user/index";
    }

    @GetMapping("/new")
        public String newUser(){
            return "user/new";
        }



}
