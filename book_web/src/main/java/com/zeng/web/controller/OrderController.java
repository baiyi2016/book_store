package com.zeng.web.controller;

/**
 * Created by Administrator on 2016/10/6.
 */

import com.fc.platform.commons.page.Page;
import com.zeng.dao.entity.Book;
import com.zeng.dao.entity.Order;
import com.zeng.dao.entity.OrderDetail;
import com.zeng.dao.entity.User;
import com.zeng.web.service.BookService;
import com.zeng.web.service.OrderDetailService;
import com.zeng.web.service.OrderService;
import com.zeng.web.vo.BookVo;
import com.zeng.web.vo.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
public class OrderController {

    @Autowired
    private OrderDetailService orderDetailService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private BookService bookService;

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
        public String orderList(ModelMap modelMap,HttpSession session,@RequestParam(name="currentPage",defaultValue = "0")Integer currentPage) {
            Order order = new Order();
            User user = (User)session.getAttribute("user");
            if(user==null) {
                return "order-list";
            }
            Integer userId = user.getUserId();
            order.setUserId(userId);

            if(currentPage<0) {
                currentPage=0;
            }
            Page<Order> orderPageList = orderService.findOrderPageByOrder(order,currentPage,null);
            int totalPages = orderPageList.getTotalPages();
            if(currentPage>totalPages-1) {
                currentPage=totalPages-1;
                orderPageList = orderService.findOrderPageByOrder(order,currentPage,null);
            }
            modelMap.put("totalPages",totalPages);
            modelMap.put("currentPage",currentPage);
            List<Order> orderList = orderPageList.getContent();

            List<OrderVo> orderVoList = new ArrayList<OrderVo>();
            for(Order o:orderList) {
                List<String> bookImgUrlList = new ArrayList<String>();
                String orderId = o.getOrderId();
                OrderDetail orderDetail = new OrderDetail();
                orderDetail.setOrderId(orderId);
                List<OrderDetail> orderDetailList = orderDetailService.findOrderDetailByOrderDetail(orderDetail);
                for(OrderDetail od:orderDetailList) {
                    Integer bookId = od.getBookId();
                    Book book = new Book();
                    book.setBookId(bookId);
                    List<Book> bookList = bookService.findBookByBook(book);
                    for(Book b:bookList) {
                        String bookImgUrl = b.getBookImgUrl();
                        bookImgUrlList.add(bookImgUrl);
                    }
                }
                OrderVo orderVo = new OrderVo();
                orderVo.setBookImgUrlList(bookImgUrlList);
                orderVo.setOrder(o);
                orderVoList.add(orderVo);
            }
            modelMap.put("orderVoList",orderVoList);
            return "order-list";
        }

}
