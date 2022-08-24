package com.itheima.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class IBookServiceTest {
    @Autowired
    private IBookService bookService;
    @Test
    void testSelectById(){

        System.out.println(bookService.getById(1));
    }
    @Test
    void testSelectAll(){
        List<Book> books = bookService.list();
        for (Book book : books) {
            System.out.println(book);
        }
    }
    @Test
     void selectPage(){
       /* IPage<Book> iPage = bookService.selectPage(2, 2);*/
        IPage iPage = new Page<>(2, 2);
        bookService.page(iPage);
        System.out.println(iPage.getPages());
        System.out.println(iPage.getCurrent());
        System.out.println(iPage.getRecords());
        System.out.println(iPage.getTotal());
        System.out.println(iPage.getSize());

    }
}
