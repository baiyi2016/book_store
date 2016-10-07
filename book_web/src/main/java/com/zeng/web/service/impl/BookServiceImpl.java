package com.zeng.web.service.impl;

import com.zeng.web.service.BookService;
import com.zeng.dao.mapper.BookMapper;
import com.zeng.dao.entity.Book;

/**
 * Created by Administrator on 2016/10/6.
 */
public class BookServiceImpl implements BookService {

    @AutoWride
    private BookMapper bookMapper;
    @Override
    public void findAll() {

    }
}
