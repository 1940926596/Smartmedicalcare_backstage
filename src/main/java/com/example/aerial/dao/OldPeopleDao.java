package com.example.aerial.dao;

import com.example.aerial.pojo.OldPeople;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OldPeopleDao {

    //得到老人信息
    List<OldPeople> getOldPeopleList();

    //按照老人Id查找
    OldPeople getOldPeopleByOldPeopleId(String oldPeopleId);

    //添加老人信息
    Integer addOldPeople(@Param("oldPeople") OldPeople oldPeople);

    //修改老人信息
    Integer updateOldPeopleByOldPeopleId(@Param("oldPeople") OldPeople oldPeople);



}
