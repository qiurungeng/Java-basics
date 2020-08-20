package com.study.test;

import com.study.bean.Person;
import com.study.config.MainConfigOfAutowired;
import com.study.config.MainConfigOfPropertyValue;
import com.study.dao.BookDao;
import com.study.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

public class IOCTest_Autowired {
    @Test
    public void test1(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfigOfAutowired.class);
        BookService bookService = context.getBean(BookService.class);
        System.out.println(bookService);

//        BookDao bookDao = context.getBean(BookDao.class);
//        System.out.println(bookDao);

        context.close();
    }
}
