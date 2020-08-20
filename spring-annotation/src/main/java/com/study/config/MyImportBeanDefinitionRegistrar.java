package com.study.config;

import com.study.bean.Rainbow;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    /**
     * 把所有需要添加到容器中的bean，调用BeanDefinitionRegistrar.registerBeanDefinition方法手动注册进来
     * @param importingClassMetadata 当前类的注解信息
     * @param registry  BeanDefinition注册类
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        boolean green = registry.containsBeanDefinition("com.study.bean.Green");
        boolean blue = registry.containsBeanDefinition("com.study.bean.Blue");
        //如果容器中已有green和blue
        if (green&&blue){
            //指定bean注册信息和名称，注册新的bean
            RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(Rainbow.class);
            registry.registerBeanDefinition("rainBow",rootBeanDefinition);
        }
    }
}
