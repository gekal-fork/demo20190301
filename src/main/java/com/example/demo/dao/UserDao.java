package com.example.demo.dao;

import com.example.demo.dto.User;
import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.SelectType;
import org.seasar.doma.boot.ConfigAutowireable;
import org.seasar.doma.jdbc.SelectOptions;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collector;

@Dao
@ConfigAutowireable
public interface UserDao {
    /**
     * ユーザーを取得します。
     */
    @Select
    List<User> selectAll();

    //@Select
    //List<User> selectOne(Integer id);

    //@Insert
    //@Transactional
    //List<User> insert(User user);


}
