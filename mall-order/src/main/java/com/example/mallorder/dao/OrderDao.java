package com.example.mallorder.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mallcommon.entity.Order;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderDao extends BaseMapper<Order> {
}
