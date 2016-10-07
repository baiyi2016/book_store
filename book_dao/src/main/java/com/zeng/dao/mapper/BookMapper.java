package com.zeng.dao.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import com.zeng.dao.entity.Book;
import com.fc.platform.commons.page.Page;
import com.fc.platform.commons.page.Pageable;

public interface BookMapper {

	int insertBook(Book book);

	int deleteBookByBookId(Integer bookId);

	int updateBook(Book book);

	Page<Book> searchBookByParams(@Param("map")Map<String, String> map , Pageable pageable);

	List<Book> searchBookByParams(@Param("map")Map<String, String> map);

} 
