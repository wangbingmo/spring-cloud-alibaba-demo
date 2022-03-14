package com.example.mallorder.feign;

import com.example.mallcommon.api.CommonResult;
import com.example.mallcommon.entity.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("mall-product")
public interface ProductService {

    @GetMapping("/product/{pid}")
    CommonResult<Product> getByPid(@PathVariable Integer pid);
}
