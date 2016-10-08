package com.zeng.web.vo;

import com.zeng.dao.entity.Book;

/**
 * Created by Administrator on 2016/10/7.
 */
public class BookVo{

    private Integer shopingCount;

    private Book book;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Integer getShopingCount() {
        return shopingCount;
    }

    public void setShopingCount(Integer shopingCount) {
        this.shopingCount = shopingCount;
    }
}
