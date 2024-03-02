package com.example.aerial.dao;

import com.example.aerial.pojo.Deal;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DealDao {

    //得到所有订单信息
    List<Deal> getDealList();

    //按照订单Id查找
    Deal getDealByDealId(String dealId);

    //按照病人Id查找
    List<Deal> getDealByOldId(String oldId);

    //按照医生Id查找
    List<Deal> getDealByDoctorId(String doctorId);

    //添加订单信息
    Integer addDeal(@Param("deal") Deal deal);

}
