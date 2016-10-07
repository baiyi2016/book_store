package com.zeng.web.controller;

/**
 * Created by Administrator on 2016/10/6.
 */
import com.zeng.web.vo.BookVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import com.zeng.web.service.BookService;
import com.fc.platform.commons.page.Page;
import com.zeng.dao.entity.Book;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping("/index")
    public String index(@RequestParam(name="currentPage",defaultValue = "0")Integer currentPage,ModelMap modelMap) {
        if(currentPage<0) {
            currentPage = 0;
        }
        Page<Book> pageBook = bookService.findBookByPage(currentPage,10);
        int totalPages = pageBook.getTotalPages();

        if(currentPage>totalPages-1) {
            currentPage = totalPages-1;
            pageBook = bookService.findBookByPage(currentPage,10);
        }
        modelMap.put("totalPages",totalPages);
        modelMap.put("currentPage",currentPage);
        List<Book> listBook = pageBook.getContent();
        modelMap.put("bookList",listBook);
        return "index";
    }

    @RequestMapping("/toaddBook")
    public String toaddBook() {
        return "add-book";
    }

    @RequestMapping("/addBook")
    public String addBook(Book book) {
        bookService.addBook(book);
        return "redirect:/index";
    }

    @RequestMapping("/shopingCart")
    public String shopingCart(@RequestParam(name="bookId",defaultValue = "")String[] bookIds,HttpSession session) {
        Map<String,BookVo> map = (Map<String,BookVo>)session.getAttribute("map");
        if(map==null) {
            map = new HashMap<String,BookVo>();
        }
        if(bookIds!=null) {
            for(String bookId:bookIds) {
                Book book = new Book();
                BookVo bookVo = new BookVo();
                book.setBookId(Integer.parseInt(bookId));
                List<Book> list = bookService.findBookByBook(book);
                if(list!=null && list.size()==1) {
                    Book bookNew = list.get(0);
                    bookVo.setBook(bookNew);
                }
                if(map.get(bookVo.getBookId())!=null) {
                    bookVo.setShopingCount(bookVo.getShopingCount()+1);
                }else {
                    bookVo.setShopingCount(1);
                }
                map.put(bookVo.getBook().getBookId()+"",bookVo);
            }
            session.setAttribute("map",map);
        }
        return "redirect:/toshopingCart";
    }

    @RequestMapping("/toshopingCart")
    public String toshopingCart() {
        return "shoppingCart";
    }


}
