package com.study.config;

import com.study.bean.Car;
import com.study.bean.Cat;
import com.study.bean.Dog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(MyBeanPostProcessor.class)
public class MainConfig3 {
    @Bean(initMethod = "init",destroyMethod = "destroy")
    public Car car(){
        return new Car();
    }

    @Bean
    public Cat cat(){
        return new Cat();
    }

    @Bean
    public Dog dog(){
        return new Dog();
    }
}
