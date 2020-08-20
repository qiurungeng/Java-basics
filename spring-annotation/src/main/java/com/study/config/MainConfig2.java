package com.study.config;

import com.study.bean.Color;
import com.study.bean.ColorFactoryBean;
import com.study.bean.Person;
import com.study.config.condition.LinuxCondition;
import com.study.config.condition.WindowsCondition;
import org.springframework.context.annotation.*;

@Configuration
@Import({
        Color.class,
        MyImportSelector.class,
        MyImportBeanDefinitionRegistrar.class
})
public class MainConfig2 {
    @Bean("bill")
    @Conditional({WindowsCondition.class})
    public Person person1(){
        return new Person("Bill Gates",62);
    }
    @Bean("linus")
    @Conditional({LinuxCondition.class})
    public Person person02(){
        return new Person("Linus",50);
    }

    @Bean
    public ColorFactoryBean colorFactoryBean(){
        return new ColorFactoryBean();
    }

}
