package com.example.aerial.controller;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSON;
import com.example.aerial.dao.OldPeopleDao;
import com.example.aerial.pojo.OldPeople;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/oldPeople")
public class OldPeopleController {
    @Autowired
    OldPeopleDao oldPeopleDao;

    @GetMapping(value = "/getOldPeopleList", produces = "application/json;charset=utf-8")
    public String getOldPeopleList() throws JsonProcessingException {
        List<OldPeople> oldPeopleList = oldPeopleDao.getOldPeopleList();
        ObjectMapper mapper1 = new ObjectMapper();
        //创建一个对象，将Java对象转换成json对象
        String oldPeopleLists = mapper1.writeValueAsString(oldPeopleList);
        return oldPeopleLists;
    }


    @GetMapping(value = "/getOldPeopleById", produces = "application/json;charset=utf-8")
    public String getOldPeopleById(@RequestParam("oldPeopleId") String oldPeople_id) throws JsonProcessingException {
        OldPeople oldPeople = oldPeopleDao.getOldPeopleByOldPeopleId(oldPeople_id);
        ObjectMapper mapper1 = new ObjectMapper();
        //创建一个对象，将Java对象转换成json对象
        String oldPeopleString = mapper1.writeValueAsString(oldPeople);
        return oldPeopleString;
    }

    @PostMapping(value = "/addOldPeople", produces = "application/json;charset=utf-8")
    public String addOldPeople(@RequestBody OldPeople oldPeople) {
        Integer integer = oldPeopleDao.addOldPeople(oldPeople);
        if (integer == 1) {
            return "success";
        } else {
            return "fail";
        }
    }

    @PostMapping(value = "/updateOldPeopleById", produces = "application/json;charset=utf-8")
    public String updateOldPeopleById(@RequestBody OldPeople oldPeople) {
        Integer integer = oldPeopleDao.updateOldPeopleByOldPeopleId(oldPeople);
        if (integer == 1) {
            return "success";
        } else {
            return "fail";
        }
    }


}
