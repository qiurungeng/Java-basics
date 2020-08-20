package com.study.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    @Value("张三")
    private String name;
    @Value("#{20-2}")
    private Integer age;
    @Value("${person.nickname}")
    private String nickname;
    public Person(String name,int age){
        this.name=name;
        this.age=age;
    }
}
