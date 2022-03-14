package com.example.mallproduct.controller;

import com.example.mallcommon.api.CommonResult;
import com.example.mallcommon.api.ResultCode;
import com.example.mallcommon.entity.Product;
import com.example.mallproduct.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @Value("${server.port}")
    String port;

    @RequestMapping("/product/{pid}")
    public CommonResult<Product> getByPid(@PathVariable("pid") Integer pid) {
        Product product = productService.getByPid(pid);
        if (product == null) {
            return CommonResult.failed(ResultCode.DATA_NOT_FOUND);
        }
        System.out.println(port);
        return CommonResult.success(product);
    }
}
