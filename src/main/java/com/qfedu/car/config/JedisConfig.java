package com.qfedu.car.config;

import com.qfedu.car.util.JedisUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author FYY
 * @date 2019/12/11 0011 下午 21:48
 */

@Configuration
public class JedisConfig {
    @Bean
    //ioc 创建对象的方式：1、单例 singleton 2、多例 调用就是创建
    //@Scope(scopeName = "singleton")
    public JedisUtil createJU() {
        return new JedisUtil();
    }
}
