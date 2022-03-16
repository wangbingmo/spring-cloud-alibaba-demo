package com.example.mallproduct.service.impl;

import com.example.mallcommon.entity.Product;
import com.example.mallproduct.dao.ProductDao;
import com.example.mallproduct.service.ProductService;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    final ProductDao productDao;

    public ProductServiceImpl(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public Product getByPid(Integer id) {
        return productDao.selectById(id);
    }
}
