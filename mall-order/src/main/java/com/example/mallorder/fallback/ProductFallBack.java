package com.example.mallorder.fallback;

import com.example.mallcommon.api.CommonResult;
import com.example.mallcommon.entity.Product;
import com.example.mallorder.feign.ProductService;
import org.springframework.stereotype.Component;

@Component
public class ProductFallBack implements ProductService {
    @Override
    public CommonResult<Product> getByPid(Integer pid) {
        Product product = new Product();
        product.setPid(-1);
        return CommonResult.success(product);
    }
}
