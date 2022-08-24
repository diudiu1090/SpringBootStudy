package com.itheima.domain;

import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlAlterUserStatement;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;


//lambok
//@Getter
//@Setter
@Data
public class Book {

    private  Integer id;
    private  String type;
    private  String name;
    private  String description;
}
