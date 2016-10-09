package com.zeng.web.vo;

import com.zeng.dao.entity.Order;

import java.util.List;

/**
 * Created by Administrator on 2016/10/9.
 */
public class OrderVo {

    private List<String> bookImgUrlList;

    private Order order;

    public List<String> getBookImgUrlList() {
        return bookImgUrlList;
    }

    public void setBookImgUrlList(List<String> bookImgUrlList) {
        this.bookImgUrlList = bookImgUrlList;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
