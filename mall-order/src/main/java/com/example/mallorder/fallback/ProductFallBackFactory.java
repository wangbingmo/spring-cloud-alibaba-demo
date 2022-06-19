package com.example.mallorder.fallback;

import com.example.mallcommon.api.CommonResult;
import com.example.mallcommon.entity.Product;
import com.example.mallorder.feign.ProductService;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class ProductFallBackFactory implements FallbackFactory<ProductService> {
    @Override
    public ProductService create(Throwable cause) {
        // 记录异常原因
        cause.printStackTrace();

        return new ProductService() {
            @Override
            public CommonResult<Product> getByPid(Integer pid) {
                Product product = new Product();
                product.setPid(-1);
                return CommonResult.success(product);
            }
        };
    }
}
