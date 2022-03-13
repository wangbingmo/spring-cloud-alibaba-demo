package com.example.mallorder.controller;

import com.example.mallcommon.api.CommonResult;
import com.example.mallcommon.entity.Order;
import com.example.mallcommon.entity.Product;
import com.example.mallorder.service.OrderService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/order/{oid}")
    public Order getById(@PathVariable("oid") Integer oid) {
        return orderService.getByOid(oid);
    }

    @RequestMapping("/order/prod/{pid}")
    public CommonResult<Order> createOrder(@PathVariable("pid") Integer pid) {
        CommonResult result = restTemplate.getForObject("http://localhost:10010/product/" + pid, CommonResult.class);
        if (result == null) {
            return CommonResult.failed();
        }
        ObjectMapper mapper = new ObjectMapper();
        Product product = mapper.convertValue(result.getData(), Product.class);
        if (product == null) {
            return CommonResult.failed("商品不存在");
        }

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
