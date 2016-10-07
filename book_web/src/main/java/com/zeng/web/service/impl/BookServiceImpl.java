package com.zeng.web.service.impl;

import com.fc.platform.commons.page.Page;
import com.zeng.dao.entity.Book;
import com.zeng.dao.mapper.BookMapper;
import com.zeng.web.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Administrator on 2016/10/6.
 */
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;
    @Override
    public Page<Book> findAll() {

        return null;
    }
}
