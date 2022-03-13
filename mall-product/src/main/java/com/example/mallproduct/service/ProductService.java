package com.example.mallproduct.service;

import com.example.mallcommon.entity.Product;
import org.springframework.stereotype.Service;

public interface ProductService {

    Product getByPid(Integer id);
}
