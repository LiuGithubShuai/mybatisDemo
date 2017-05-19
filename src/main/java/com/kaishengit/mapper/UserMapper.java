package com.kaishengit.mapper;

import com.kaishengit.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/5/8.
 */
public interface UserMapper {

    void save(User user);

    void update(User user);

    void del(Integer id);

    //User findById(Integer id);

    /*//User findByUsernameAndPassword(@Param("name") String username, @Param("pwd") String password);*//*方法一*//*
    //User findByUsernameAndPassword(String username , String password);*//*方法二*//*
    //User findByUsernameAndPassword(Map<String,String> params);*//*方法三*/






















    /*User findByUsernameAndPassword(String username, String password);*/
    /*User findByUsernameAndPassword(@Param("name") String username, @Param("pwd") String password);*/

    User findByUsernameAndPassword(Map<String ,String> params);

    void batchSave(List<User> userList);
}
