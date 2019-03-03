package com.example.demo.service;

import com.example.demo.dao.UserDao;
import com.example.demo.dto.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    public List<User> selectAll(){
        List<User> users = userDao.selectAll();
        return users;
    }
}
