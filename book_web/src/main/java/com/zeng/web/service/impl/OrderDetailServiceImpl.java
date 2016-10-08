package com.zeng.web.service.impl;

import com.zeng.dao.entity.Order;
import com.zeng.dao.entity.OrderDetail;
import com.zeng.dao.mapper.OrderDetailMapper;
import com.zeng.dao.mapper.OrderMapper;
import com.zeng.web.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2016/10/8.
 */
@Service
public class OrderDetailServiceImpl implements OrderDetailService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderDetailMapper orderDetailMapper;

    @Override
    public boolean addOrderDetail(OrderDetail orderDetail) {
        //订单详情中有订单属性
        try {
            Order order = orderDetail.getOrder();
            orderMapper.insertOrder(order);
            orderDetailMapper.insertOrderDetail(orderDetail);
        }catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }
}
