package com.example.aerial.dao;

import com.example.aerial.pojo.Doctor;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DoctorDao {
    //得到医生信息
    List<Doctor> getDoctorList();

    //按照医生Id查找
    Doctor getDoctorByDoctorId(String doctorId);

    //添加医生信息
    Integer addDoctor(@Param("doctor") Doctor doctor);

    //修改医生分数  (用户端)
    Integer updateDoctorScoreById(@Param("doctorId") Integer doctorId, @Param("score") Integer doctorScore);

    //修改医生信息
    Integer updateDoctorByDoctorId(@Param("doctor") Doctor doctor);

}
