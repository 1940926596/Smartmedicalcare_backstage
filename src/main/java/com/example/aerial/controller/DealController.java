package com.example.aerial.controller;

import com.example.aerial.dao.DealDao;
import com.example.aerial.pojo.Deal;
import com.example.aerial.pojo.Doctor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/deal")
public class DealController {

    @Autowired
    private DealDao dealDao;

    @GetMapping(value = "/getDealList", produces = "application/json;charset=utf-8")
    public String getDealLists() throws JsonProcessingException {
        List<Deal> dealList = dealDao.getDealList();
        ObjectMapper mapper1 = new ObjectMapper();
        //创建一个对象，将Java对象转换成json对象
        String dealLists = mapper1.writeValueAsString(dealList);
        return dealLists;
    }

    @GetMapping(value = "/getDealByDealId", produces = "application/json;charset=utf-8")
    public String getDealByDealId(@RequestParam("dealId") String dealId) throws JsonProcessingException {
        Deal dealList = dealDao.getDealByDealId(dealId);
        ObjectMapper mapper1 = new ObjectMapper();
        //创建一个对象，将Java对象转换成json对象
        String dealLists = mapper1.writeValueAsString(dealList);
        return dealLists;
    }

    @GetMapping(value = "/getDealByOldId", produces = "application/json;charset=utf-8")
    public String getDealByOldId(@RequestParam("oldId") String oldId) throws JsonProcessingException {
        List<Deal> dealList = dealDao.getDealByOldId(oldId);
        ObjectMapper mapper1 = new ObjectMapper();
        //创建一个对象，将Java对象转换成json对象
        String dealLists = mapper1.writeValueAsString(dealList);
        return dealLists;
    }

    @GetMapping(value = "/getDealByDoctorId", produces = "application/json;charset=utf-8")
    public String getDealByDoctorId(@RequestParam("doctorId") String doctorId) throws JsonProcessingException {
        List<Deal> dealList = dealDao.getDealByDoctorId(doctorId);
        ObjectMapper mapper1 = new ObjectMapper();
        //创建一个对象，将Java对象转换成json对象
        String dealLists = mapper1.writeValueAsString(dealList);
        return dealLists;
    }

    @PostMapping(value="/addDeal",produces = "application/json;charset=utf-8")
    public String addDeal(@RequestBody Deal deal){
        Integer integer = dealDao.addDeal(deal);
        if (integer == 1) {
            return "success";
        } else {
            return "fail";
        }
    }

}
