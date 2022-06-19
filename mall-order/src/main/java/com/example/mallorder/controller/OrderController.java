package com.example.mallorder.controller;

import com.example.mallcommon.api.CommonResult;
import com.example.mallcommon.api.ResultCode;
import com.example.mallcommon.entity.Order;
import com.example.mallcommon.entity.Product;
import com.example.mallorder.feign.ProductService;
import com.example.mallorder.service.OrderService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequestMapping("/order")
public class OrderController {

    final OrderService orderService;
    final ProductService productService;

    public OrderController(OrderService orderService,
                           @Qualifier("com.example.mallorder.feign.ProductService") ProductService productService) {
        this.orderService = orderService;
        this.productService = productService;
    }

    @RequestMapping("/{oid}")
    public Order getById(@PathVariable("oid") Integer oid) {
        return orderService.getByOid(oid);
    }

    @RequestMapping("/prod/{pid}")
    public CommonResult<Order> createOrder(@PathVariable("pid") Integer pid) {
        CommonResult<Product> result = productService.getByPid(pid);
        if (result == null
                || result.getCode() != ResultCode.SUCCESS.getCode()
                || result.getData().getPid() == -1) {
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
