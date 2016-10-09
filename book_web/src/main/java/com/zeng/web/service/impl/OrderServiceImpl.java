package com.zeng.web.service.impl;

import com.fc.platform.commons.page.Page;
import com.fc.platform.commons.page.PageRequest;
import com.zeng.dao.entity.Order;
import com.zeng.dao.entity.OrderDetail;
import com.zeng.dao.mapper.OrderDetailMapper;
import com.zeng.dao.mapper.OrderMapper;
import com.zeng.web.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/10/8.
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderDetailMapper orderDetailMapper;

    @Override
    public List<Order> findAll() {
        return orderMapper.searchOrderByParams(null);
    }

    @Override
    public List<Order> findOrderByOrder(Order order) {

        Map<String,String> map = new HashMap<String,String>();
        if(order.getOrderId()!=null){
            map.put("orderId",order.getOrderId()+"");
        }
        if(order.getUserId()!=null) {
            map.put("userId",order.getUserId()+"");
        }
        return orderMapper.searchOrderByParams(map);
    }

    @Override
    public Page<Order> findOrderPageByOrder(Order order,Integer page, Integer rowCount ) {
        if(page==null) {
            page=0;
        }
        if(rowCount==null) {
            rowCount=3;
        }
        PageRequest pageRequest = new PageRequest(page,rowCount);
        Map<String,String> map = new HashMap<String,String>();
        if(order.getOrderId()!=null){
            map.put("orderId",order.getOrderId()+"");
        }
        if(order.getUserId()!=null) {
            map.put("userId",order.getUserId()+"");
        }
        return orderMapper.searchOrderByParams(map, pageRequest);
    }

    @Override
    public boolean addOrder(Order order) {
        if(order==null) {
            return false;
        }
        orderMapper.insertOrder(order);
        List<OrderDetail> list = order.getOrderDetailList();
        if(list!=null) {
            for(OrderDetail orderDetail:list) {
                orderDetailMapper.insertOrderDetail(orderDetail);
            }
        }else {
            return false;
        }
        return true;
    }
}
