package com.zeng.web.controller;

/**
 * Created by Administrator on 2016/10/6.
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import com.zeng.web.service.BookService;
import com.fc.platform.commons.page.Page;
import com.zeng.dao.entity.Book;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping("index")
    public String index(@RequestParam(name="currentPage",defaultValue = "0")Integer currentPage,ModelMap modelMap) {
        Page<Book> pageBook = bookService.findBookByPage(currentPage,10);
        List<Book> listBook = pageBook.getContent();
        modelMap.put("bookList",listBook);
        return "index";
    }

    @RequestMapping("toaddBook")
    public String toaddBook() {
        return "add-book";
    }

    @RequestMapping("addBook")
    public String addBook(Book book) {
        bookService.addBook(book);
        return "index";
    }


}
