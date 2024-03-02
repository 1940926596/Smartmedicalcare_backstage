package com.example.aerial.controller;

import com.example.aerial.dao.DominatorDao;
import com.example.aerial.pojo.Dominator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/dominator")
public class DominatorController {

    @Autowired
    DominatorDao dominatorDao;

    @GetMapping(value = "/getDominatorById",produces = "application/json;charset=utf-8")
    public String getDominator(@Param("dominatorId") String dominatorId) throws JsonProcessingException {
        Dominator dominator = dominatorDao.getDominatorByDominatorId(dominatorId);

        ObjectMapper mapper = new ObjectMapper();
        //创建一个对象，将Java对象转换成json对象
        String dominatorString = mapper.writeValueAsString(dominator);

        return dominatorString;
    }

}
