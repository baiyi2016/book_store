package com.zeng.web.controller;

/**
 * Created by Administrator on 2016/10/6.
 */

import com.fc.platform.commons.page.Page;
import com.zeng.dao.entity.Book;
import com.zeng.dao.entity.Order;
import com.zeng.dao.entity.OrderDetail;
import com.zeng.web.service.BookService;
import com.zeng.web.service.OrderDetailService;
import com.zeng.web.service.OrderService;
import com.zeng.web.vo.BookVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class OrderDetailController {

    @Autowired
    private OrderDetailService orderDetailService;

    @Autowired
    private OrderService orderService;

    @RequestMapping("/addOrderDetail")
    public String index(OrderDetail orderDetail,ModelMap modelMap) {
//        Integer orderId = orderDetail.getOrderId();
//        Order order = new Order();
//        order.setOrderId(orderId);
//        orderService.findOrderByOrder(order);
          return "index";
    }

}
