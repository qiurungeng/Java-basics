package com.study.bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Data
public class Boss {
    private Car car;

    @Autowired
    public Boss(Car car){
        this.car=car;
        System.out.println("Boss有参构造器");
    }

}
