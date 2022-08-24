package com.itheima.controller.impl;

import lombok.Data;

@Data
public class R {
    private Boolean flag;
    private Object date;
    private String msg;

    public R(){}
    public R(Boolean flag){

        this.flag=flag;
    }
    public R(Boolean flag ,Object date){
       this.flag=flag;
       this.date=date;
    }
    public R(String msg){
       this.flag=false;
       this.msg=msg;
    }
}
