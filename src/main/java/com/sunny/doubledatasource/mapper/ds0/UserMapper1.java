package com.sunny.doubledatasource.mapper.ds0;


import com.sunny.doubledatasource.bean.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Description TODO
 * @Author sunny
 * @Date 2019-07-01 15:28
 */
public interface UserMapper1 {
    @Select("select * from user")
    List<User> queryAll();

    @Insert("insert into user(username,password) values(#{username},#{password})")
    void insert(User user);
}