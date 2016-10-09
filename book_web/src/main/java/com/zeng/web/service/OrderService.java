package com.zeng.web.service;

import com.fc.platform.commons.page.Page;
import com.zeng.dao.entity.Order;
import com.zeng.dao.entity.OrderDetail;

import java.util.List;

/**
 * Created by Administrator on 2016/10/6.
 */

public interface OrderService {

    public List<Order> findAll();

    public List<Order> findOrderByOrder(Order order);

    public boolean addOrder(Order order);

    public Page<Order> findOrderPageByOrder(Order order,Integer page, Integer rowCount );

}
