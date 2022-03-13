package com.example.mallorder.service.impl;

import com.example.mallcommon.entity.Order;
import com.example.mallorder.dao.OrderDao;
import com.example.mallorder.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderDao orderDao;

    @Override
    public void createOrder(Order order) {
        orderDao.insert(order);
    }

    @Override
    public Order getByOid(Integer oid) {
        return orderDao.selectById(oid);
    }


}
