package com.example.demo.service;

import com.example.demo.domain.dto.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
/**ユーザ情報を操作するserviceのインターフェース*/
public interface UserService {

    List<User> selectAll();



}
