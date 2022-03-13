package com.example.mallorder.service;

import com.example.mallcommon.entity.Order;

public interface OrderService {
    void createOrder(Order order);

    Order getByOid(Integer oid);
}
