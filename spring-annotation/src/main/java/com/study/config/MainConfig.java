package com.study.config;

import com.study.bean.Person;
import com.study.service.BookService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

//配置类=配置文件
@Configuration
@ComponentScan(value = "com.study",excludeFilters = {
        @ComponentScan.Filter(
                classes = {Controller.class, Service.class},
                type = FilterType.ANNOTATION),
        @ComponentScan.Filter(
                type = FilterType.ASSIGNABLE_TYPE,
                classes = {BookService.class}
        )
})
public class MainConfig {

    //给容器中注册一个bean，其类型为返回值类型，id为方法名
    @Bean
    public Person person(){
        return new Person("小米",12);
    }
    @Bean
    public Person person2(){
        Person person = new Person();
        person.setName("红米");
        person.setAge(44);
        return person;
    }
    @Bean("改名") //Bean注解中可设置name,value字段
    public Person person3(){
        return new Person("黑米",12);
    }
}
