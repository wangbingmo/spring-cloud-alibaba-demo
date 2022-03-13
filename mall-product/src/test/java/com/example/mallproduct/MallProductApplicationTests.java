package com.example.mallproduct;

import com.example.mallcommon.entity.Product;
import com.example.mallproduct.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MallProductApplicationTests {

    @Autowired
    ProductService productService;

    @Test
    void contextLoads() {
    }

    @Test
    void getProductByPid() {
        Product product = productService.getByPid(1);
        System.out.println(product);
    }

}
