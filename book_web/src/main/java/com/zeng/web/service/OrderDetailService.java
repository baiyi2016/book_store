package com.zeng.web.service;

import com.fc.platform.commons.page.Page;
import com.zeng.dao.entity.Book;
import com.zeng.dao.entity.OrderDetail;
import com.zeng.dao.mapper.OrderDetailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/10/6.
 */

public interface OrderDetailService {

    public boolean addOrderDetail(OrderDetail orderDetail);

    public List<OrderDetail> findOrderDetailByOrderDetail(OrderDetail orderDetail);

}
