package com.study.config;

import com.study.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

//使用PropertySource加载外部配置文件中的kv保存到运行时环境变量,加载完外部配置文件后使用${}取出配置文件的值
@PropertySource(value = {"classpath:/person.properties"})
@Configuration
public class MainConfigOfPropertyValue {
    @Bean
    public Person person(){
        return new Person();
    }
}
