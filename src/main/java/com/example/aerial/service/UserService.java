package com.example.aerial.service;

import com.example.aerial.dao.UserDao;
import com.example.aerial.pojo.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService {
    @Resource
    private UserDao userDao;

    public List<User> getUserList(){
        List<User> userList = userDao.getUserList();
        return userList;
    }
}
