package com.slwer.reader.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.slwer.reader.entity.Book;

public interface BookService {
    /**
     * 分页查询图书
     *
     * @param categoryId 分类编号
     * @param order      排序方式
     * @param page       页号
     * @param rows       每页记录数
     * @return 分页对象
     */
    IPage<Book> selectPage(Long categoryId, String order, Integer page, Integer rows);
}
