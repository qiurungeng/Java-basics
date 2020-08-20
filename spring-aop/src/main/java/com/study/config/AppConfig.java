package com.study.config;

import com.study.diy.AnnotationPointCut;
import com.study.service.UserService;
import com.study.service.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

/**
 * @EnableAspectJAutoProxy
 * @Import({AnnotationPointCut.class})
 * 以上两个注解能将自定义的切面类配置到该配置类中，使其生效
 */
@Configuration
@EnableAspectJAutoProxy
@Import({AnnotationPointCut.class})/*@Aspect可以生效,相当于Configuration类作用,都是配置类*/
public class AppConfig {
    @Bean
    public UserService getUserService(){
        return new UserServiceImpl();
    }
}
