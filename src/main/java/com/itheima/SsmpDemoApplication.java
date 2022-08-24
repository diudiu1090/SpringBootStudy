package com.itheima;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SsmpDemoApplication {

    public static void main(String[] args) {
        //可以在启动boot程序时断开读取外部临时配置的入口，也就是去掉读取外部数据的形参
        SpringApplication.run(SsmpDemoApplication.class, args);
//        SpringApplication.run(SsmpDemoApplication.class);
    }

}
