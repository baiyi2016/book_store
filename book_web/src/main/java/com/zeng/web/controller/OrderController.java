package com.zeng.web.controller;

/**
 * Created by Administrator on 2016/10/6.
 */

import com.zeng.dao.entity.Order;
import com.zeng.dao.entity.OrderDetail;
import com.zeng.dao.entity.User;
import com.zeng.web.service.OrderDetailService;
import com.zeng.web.service.OrderService;
import com.zeng.web.vo.BookVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
public class OrderController {

    @Autowired
    private OrderDetailService orderDetailService;

    @Autowired
    private OrderService orderService;

    @RequestMapping("/addOrder")
    @Transactional
    public String addOrder(HttpSession session) {
        Map<String,BookVo> map = (Map<String,BookVo>)session.getAttribute("map");
        Collection<BookVo> collection = map.values();
        List<OrderDetail> orderDetailList = new ArrayList<OrderDetail>();
        String orderId = UUID.randomUUID().toString();
        double sum = 0;
        for(BookVo bookVo:collection) {
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setBookId(bookVo.getBook().getBookId());
            orderDetail.setNumber(bookVo.getShopingCount() + "");
            orderDetail.setTradePrice(Double.parseDouble(bookVo.getBook().getBookPrice()));
            orderDetail.setOrderId(orderId);
            orderDetailList.add(orderDetail);
            sum+=bookVo.getShopingCount()*Integer.parseInt(bookVo.getBook().getBookPrice());
        }
        Order order = new Order();
        User user = (User)session.getAttribute("user");
        Integer userId = null;
        if(user!=null) {
            userId = user.getUserId();
        }
        order.setUserId(userId);
        order.setOrderId(orderId);
        order.setCreateTime(new Date());
        order.setOrderDetailList(orderDetailList);
        order.setOrderPrice(sum);
        order.setOrderStatus("已下单");
        orderService.addOrder(order);
        session.setAttribute("map",null);

        return "redirect:/orderList";
    }


        @RequestMapping("/orderList")
        public String orderList(ModelMap modelMap,HttpSession session) {
            Order order = new Order();
            User user = (User)session.getAttribute("user");
            Integer userId = null;
            if(user!=null) {
                userId = user.getUserId();
            }
            order.setUserId(userId);
            List<Order> orderList = orderService.findOrderByOrder(order);
            System.out.println(orderList);
            modelMap.put("orderList",orderList);
            return "order-list";
        }

}
