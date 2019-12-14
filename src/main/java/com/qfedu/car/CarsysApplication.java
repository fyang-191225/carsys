package com.qfedu.car;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 开关类
 */
@SpringBootApplication//标记 这是SpringBoot项目
@EnableSwagger2   //启用Swagger的扫描
@MapperScan("com.qfedu.car.user.dao,com.qfedu.car.oss.dao,com.qfedu.car.news.dao")
public class CarsysApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarsysApplication.class, args);
    }

}
