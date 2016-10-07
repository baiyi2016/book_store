package com.zeng.web.service;

import com.fc.platform.commons.page.Page;
import com.zeng.dao.entity.Book;

/**
 * Created by Administrator on 2016/10/6.
 */
public interface BookService {

    public Page<Book> findAll();
}
