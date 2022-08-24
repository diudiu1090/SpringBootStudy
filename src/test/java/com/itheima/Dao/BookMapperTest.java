package com.itheima.Dao;

import com.itheima.dao.BookMapper;
import com.itheima.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookMapperTest {
    @Autowired
    private BookMapper bookMapper;

    @Test
    public void testsave(){
        Book book =new Book();
        book.setName("测试123");
        book.setType("测试");
        book.setDescription("测试");
        System.out.println(bookMapper.insert(book));
    }
    @Test
    public void testUpdate(){
        Book book =new Book();
        book.setId(14);
        book.setName("测试1234");
        book.setType("测试");
        book.setDescription("测试");
        bookMapper.updateById(book);
    }

}
