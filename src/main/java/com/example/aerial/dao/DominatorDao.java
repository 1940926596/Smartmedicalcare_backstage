package com.example.aerial.dao;

import com.example.aerial.pojo.Dominator;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DominatorDao {

    //查找管理员登录
    Dominator getDominatorByDominatorId(String dominatorId);

}
