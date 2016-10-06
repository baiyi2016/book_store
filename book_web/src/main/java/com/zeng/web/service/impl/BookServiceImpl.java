package com.zeng.web.service.impl;

import com.zeng.web.service.BookService;
import com.zeng.dao.mapper.BookMapper;
import com.zeng.dao.entity.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fc.platform.commons.page.PageRequest;
import com.fc.platform.commons.page.Page;

/**
 * Created by Administrator on 2016/10/6.
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;

    @Override
    public Page<Book> findBookByPage(Integer page,Integer rowCount) {
        if(page==null) {
            page=0;
        }
        if(rowCount==null){
            rowCount=10;
        }
        PageRequest pageRequest = new PageRequest(page,rowCount);
        return bookMapper.searchBookByParams(null, pageRequest);
    }

    @Override
    public int addBook(Book book) {
        int i=0;
        try {
            i = bookMapper.insertBook(book);
        }catch(Exception ex) {
            ex.printStackTrace();
        }
        return i;
    }
}


