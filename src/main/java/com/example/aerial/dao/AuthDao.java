package com.example.aerial.dao;

import com.example.aerial.pojo.Auth;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AuthDao {
    List<Auth> getAllAuthList();
}
