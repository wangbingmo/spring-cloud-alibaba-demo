package com.example.mallorder.feign;

import com.example.mallcommon.api.CommonResult;
import com.example.mallcommon.entity.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "mall-product", fallback = ProductServiceFallBack.class, configuration = FeignConfiguration.class)
public interface ProductService {

    @GetMapping("/product/{pid}")
    CommonResult<Product> getByPid(@PathVariable Integer pid);
}

class FeignConfiguration {
    @Bean
    public ProductServiceFallBack productServiceFallBack() {
        return new ProductServiceFallBack();
    }
}

class ProductServiceFallBack implements ProductService {

    @Override
    public CommonResult<Product> getByPid(Integer pid) {
        return null;
    }
}
