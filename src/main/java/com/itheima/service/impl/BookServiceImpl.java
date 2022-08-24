package com.itheima.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.dao.BookMapper;
import com.itheima.domain.Book;
import com.itheima.service.IBookService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl  extends ServiceImpl<BookMapper, Book> implements IBookService {
    @Autowired
    private  BookMapper bookMapper;

    @Override
    public IPage<Book> getPage(int currentPage, int pageSize) {
        IPage iPage = new Page(currentPage, pageSize);
        bookMapper.selectPage(iPage,null);
        return  iPage;
    }

    @Override
    public IPage<Book> getPage(int currentPage, int pageSize, Book book) {

        LambdaQueryWrapper<Book> lqm =new LambdaQueryWrapper<Book>();
        lqm.like(Strings.isNotEmpty(book.getType()),Book::getType, book.getType());
        lqm.like(Strings.isNotEmpty(book.getName()),Book::getName, book.getName());
        lqm.like(Strings.isNotEmpty(book.getDescription()),Book::getDescription, book.getDescription());
        IPage iPage = new Page(currentPage, pageSize);
        bookMapper.selectPage(iPage,lqm);
        return  iPage;
    }


}
