package com.example.aerial.dao;

import com.example.aerial.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao {
    List<User> getUserList();

}
