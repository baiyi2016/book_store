package com.zeng.web.service.impl;

import com.fc.platform.commons.page.Page;
import com.fc.platform.commons.page.PageRequest;
import com.zeng.web.service.BookService;
import com.zeng.dao.mapper.BookMapper;
import com.zeng.dao.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/10/6.
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;

    @Override
    public Page<Book> findBookByPage(Integer page, Integer rowCount) {
        if(page==null) {
            page=0;
        }
        if(rowCount==null) {
            rowCount=10;
        }
        PageRequest pageRequest = new PageRequest(page,rowCount);
        return bookMapper.searchBookByParams(null,pageRequest);
    }

    @Override
    public List<Book> findBookByBook(Book book) {
        Map<String,String> map= new HashMap<String,String>();
        map.put("bookId",book.getBookId()+"");
        map.put("bookName",book.getBookName());
        return bookMapper.searchBookByParams(map);
    }

    @Override
    public int addBook(Book book) {
        int i=-1;
        try {
           i = bookMapper.insertBook(book);
        }catch (Exception ex) {
            ex.printStackTrace();
        }
        return i;
    }
}
