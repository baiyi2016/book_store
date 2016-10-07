package com.zeng.web.service;

import com.fc.platform.commons.page.Page;
import com.zeng.dao.entity.Book;

/**
 * Created by Administrator on 2016/10/6.
 */


import java.util.List;

public interface BookService {

    public Page<Book> findBookByPage(Integer page,Integer rowCount);

    public List<Book> findBookByBook(Book book);

    public int addBook(Book book);
}
