package com.example.aerial.controller;


import com.example.aerial.dao.AuthDao;
import com.example.aerial.dao.DealDao;
import com.example.aerial.pojo.Auth;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthDao authDao;
    @GetMapping(value = "/getAuthList", produces = "application/json;charset=utf-8")
    public String  getAuthList() throws JsonProcessingException {

        List<Auth> allAuthList = authDao.getAllAuthList();
        ObjectMapper mapper1 = new ObjectMapper();
        //创建一个对象，将Java对象转换成json对象
        String authList = mapper1.writeValueAsString(allAuthList);
        return authList;

    }
}
