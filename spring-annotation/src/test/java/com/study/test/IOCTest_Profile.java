package com.study.test;

import com.study.config.MainConfigOfProfile;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;

public class IOCTest_Profile {
    @Test
    public void test1(){
        //要指定环境，容器需要使用无参构造
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        //激活环境
        context.getEnvironment().setActiveProfiles("dev","test");
        //注册配置类
        context.register(MainConfigOfProfile.class);
        //启动刷新容器
        context.refresh();

        String[] beanNamesForType = context.getBeanNamesForType(DataSource.class);
        for (String s : beanNamesForType) {
            System.out.println(s);
        }
        context.close();
    }
}
