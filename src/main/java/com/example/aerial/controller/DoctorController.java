package com.example.aerial.controller;


import com.example.aerial.dao.DoctorDao;
import com.example.aerial.pojo.Doctor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.geometry.Pos;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    private DoctorDao doctorDao;

    @GetMapping(value = "/getDoctorList", produces = "application/json;charset=utf-8")
    public String getDoctorList() throws JsonProcessingException {
        List<Doctor> doctorList = doctorDao.getDoctorList();
        ObjectMapper mapper1 = new ObjectMapper();
        //创建一个对象，将Java对象转换成json对象
        String doctorLists = mapper1.writeValueAsString(doctorList);
        return doctorLists;
    }


    @GetMapping(value = "/getDoctorById", produces = "application/json;charset=utf-8")
    public String getDoctorById(@RequestParam("doctorId") String doctor_id) throws JsonProcessingException {
        Doctor doctor = doctorDao.getDoctorByDoctorId(doctor_id);
        ObjectMapper mapper1 = new ObjectMapper();
        //创建一个对象，将Java对象转换成json对象
        String doctorString = mapper1.writeValueAsString(doctor);
        return doctorString;
    }

    @PostMapping(value = "/addDoctor", produces = "application/json;charset=utf-8")
    public String addDoctor(@RequestBody Doctor doctor) {
        Integer integer = doctorDao.addDoctor(doctor);
        if (integer == 1) {
            return "success";
        } else {
            return "fail";
        }
    }

    @GetMapping(value = "/updateDoctorScoreById", produces = "application/json;charset=utf-8")
    public String updateDoctorScoreById(@RequestParam("doctorId") Integer doctorId, @RequestParam("doctorScore") Integer doctorScore) {
        Integer integer = doctorDao.updateDoctorScoreById(doctorId, doctorScore);
        if (integer == 1) {
            return "success";
        } else {
            return "fail";
        }
    }

    @PostMapping(value = "/updateDoctorById", produces = "application/json;charset=utf-8")
    public String updateDoctorById(@RequestBody Doctor doctor) {
        Integer integer = doctorDao.updateDoctorByDoctorId(doctor);
        if (integer == 1) {
            return "success";
        } else {
            return "fail";
        }
    }

}
