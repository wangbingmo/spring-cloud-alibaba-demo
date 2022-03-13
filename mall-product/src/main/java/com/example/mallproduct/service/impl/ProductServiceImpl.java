package com.example.mallproduct.service.impl;

import com.example.mallcommon.entity.Product;
import com.example.mallproduct.dao.ProductDao;
import com.example.mallproduct.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    public ProductDao productDao;

    @Override
    public Product getByPid(Integer id) {
        return productDao.selectById(id);
    }
}
