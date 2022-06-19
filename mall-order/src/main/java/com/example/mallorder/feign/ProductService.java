package com.example.mallorder.feign;

import com.example.mallcommon.api.CommonResult;
import com.example.mallcommon.entity.Product;
import com.example.mallorder.fallback.ProductFallBack;
import com.example.mallorder.fallback.ProductFallBackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// fallback 是Feign用来进行容错处理的
// 其中若指定 fallback = xxx.class, 则会在指定服务调用失败时,执行该类中的方法, 如下
// @FeignClient(name = "mall-product", fallback = ProductFallBack.class)
// 若想知道调用失败的原因,则使用 fallbackFactory, 实现 FallBackFactory<T> 接口,便能捕捉的异常
@FeignClient(name = "mall-product", fallbackFactory = ProductFallBackFactory.class)
public interface ProductService {

    @GetMapping("/product/{pid}")
    CommonResult<Product> getByPid(@PathVariable Integer pid);
}
