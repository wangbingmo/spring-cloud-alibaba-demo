package com.example.mallproduct.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mallcommon.entity.Product;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductDao extends BaseMapper<Product> {
}
