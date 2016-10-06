package com.zeng.web.service;

/**
 * Created by Administrator on 2016/10/6.
 */
import com.fc.platform.commons.page.Page;
import com.zeng.dao.entity.Book;

public interface BookService {

    public Page<Book> findBookByPage(Integer page,Integer rowCount);

    public int addBook(Book book);
}
