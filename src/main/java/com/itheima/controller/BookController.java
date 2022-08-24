package com.itheima.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.itheima.controller.impl.R;
import com.itheima.domain.Book;
import com.itheima.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/*@Controller
@ResponseBody*/
@RestController
@RequestMapping("/books")
@CrossOrigin
public class BookController {
    @Autowired
    private IBookService iBookService;

    //查询所有
    @GetMapping
    public R getAll() {
        R  r = new R(true,iBookService.list());
        return r;
    }

    //根据id查询
    @GetMapping("{id}")
    public R getById(@PathVariable Integer id) {
         R r = new R(true,iBookService.getById(id));
        return  r;
    }

    //新增数据
    @PostMapping
    public R save(@RequestBody Book book) {
        R r = new R(iBookService.save(book));
        return r;
    }

//根据id删除
    @DeleteMapping("{id}")
    public R delete(@PathVariable Integer id) {
        R r = new R(iBookService.removeById(id));
        return r;
    }

//根据id更新数据
   @PutMapping
   public R updateById(@RequestBody Book book){
       R r = new R(iBookService.updateById(book));
       return r;
   }
//分页查询
    @GetMapping("{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage, @PathVariable int pageSize,Book book){
        IPage<Book> page = iBookService.getPage(currentPage, pageSize,book);
        //如果当前页码大于总页码，就定位到最大页码
        if(currentPage>page.getPages()){
           page = iBookService.getPage((int)page.getPages(), pageSize,book);
        }
        R r = new R(true,page);
        return r;
    }


}