package com.study.ext;

import com.study.bean.Blue;
import com.study.bean.Yellow;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
@ComponentScan("com.study.ext")
@Configuration
public class ExtConfig {
    //随便加上几个以前写的组件
    @Bean
    public Blue blue(){
        return new Blue();
    }
    @Bean
    public Yellow Yellow(){
        return new Yellow();
    }
}
