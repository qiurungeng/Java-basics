package com.study.config;

import com.study.bean.Car;
import com.study.bean.Color;
import com.study.dao.BookDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan({"com.study.service","com.study.controller","com.study.dao","com.study.bean"})
public class MainConfigOfAutowired {
    @Bean("bookDao2")
    public BookDao bookDao(){
        BookDao bookDao=new BookDao();
        bookDao.setLabel("2");
        return bookDao;
    }

    @Bean
    public Color color(Car car){
        return new Color();
    }


}
