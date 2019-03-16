package com.example.demo.service;

import com.example.demo.domain.dao.UserDao;
import com.example.demo.domain.dao.UserRoleDao;
import com.example.demo.domain.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Autowired
    UserRoleDao userRoleDao;

    public List<User> selectAll(){
        List<User> users = userDao.selectAll();
        return users;
    }

    /**
     * ユーザーを追加します。
     *
     * @param inputUser
     * @return
     */
    public User create(final User inputUser) {
        Assert.notNull(inputUser, "inputUser must not be null");
        userDao.insert(inputUser);

        return inputUser;
    }
}
