package com.example.aerial.controller;


import com.example.aerial.pojo.User;
import com.example.aerial.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/user_list",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getForum_User() throws JsonProcessingException {
        List<User> userList = userService.getUserList();
        ObjectMapper mapper1 = new ObjectMapper();
        //创建一个对象，将Java对象转换成json对象
        String userLists = mapper1.writeValueAsString(userList);
        return userLists;
    }

}
