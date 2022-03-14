package com.example.mallorder.controller;

import com.example.mallcommon.api.CommonResult;
import com.example.mallcommon.api.ResultCode;
import com.example.mallcommon.entity.Order;
import com.example.mallcommon.entity.Product;
import com.example.mallorder.feign.ProductService;
import com.example.mallorder.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    ProductService productService;

    @RequestMapping("/order/{oid}")
    public Order getById(@PathVariable("oid") Integer oid) {
        return orderService.getByOid(oid);
    }

    @RequestMapping("/order/prod/{pid}")
    public CommonResult<Order> createOrder(@PathVariable("pid") Integer pid) {
        CommonResult<Product> result = productService.getByPid(pid);
        if (result == null || result.getCode() != ResultCode.SUCCESS.getCode()) {
            return CommonResult.failed("查询商品信息失败");
        }

        Product product = result.getData();
        Order order = new Order();
        order.setUid(1);
        order.setUsername("测试用户");
        order.setPid(pid);
        order.setPname(product.getPname());
        order.setPprice(product.getPprice());
        order.setNumber(1);
        orderService.createOrder(order);

        return CommonResult.success(order);
    }
}
