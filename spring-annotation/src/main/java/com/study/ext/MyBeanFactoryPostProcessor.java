package com.study.ext;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("MyBeanFactoryPostProcessor...execute postProcessBeanFactory ...");
        String[] names = beanFactory.getBeanDefinitionNames();
        int count = beanFactory.getBeanDefinitionCount();
        System.out.println("当前beanFactory中有"+count+"个bean");
        System.out.println(Arrays.asList(names));
    }
}
