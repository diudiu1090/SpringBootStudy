package com.itheima.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.dao.BookMapper;
import com.itheima.domain.Book;
import com.itheima.service.BookService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl2 implements BookService2 {
    @Autowired
    private BookMapper bookMapper;

    @Override
    public Boolean save(Book book) {
       return bookMapper.insert(book)>0;

    }

    @Override
    public Boolean update(Book book) {
        return bookMapper.updateById(book) >0;
    }

    @Override
    public Boolean delete(Integer id) {
        return bookMapper.deleteById(id)>0;
    }

    @Override
    public Book selectById(Integer id) {
        return bookMapper.selectById(id);
    }

    @Override
    public List<Book> selectAll() {
      return bookMapper.selectList(null);
    }

    @Override
    public IPage<Book> selectPage(int currentPage, int pageSize) {
        IPage iPage =new Page(currentPage,pageSize);
        bookMapper.selectPage(iPage,null);
        return iPage;

    }


}
