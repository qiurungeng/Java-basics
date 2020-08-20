package com.study.bean;

import org.springframework.beans.factory.FactoryBean;
//创建一个Spring定义的FactoryBean
public class ColorFactoryBean implements FactoryBean<Color> {
    /**
     * 返回一个color对象，它将被添加到Spring容器中
     * @return 一个color对象
     * @throws Exception
     */
    @Override
    public Color getObject() throws Exception {
        System.out.println("color factory bean ... getObject()...");
        return new Color();
    }

    @Override
    public Class<?> getObjectType() {
        return Color.class;
    }

    /**
     * 是否为单实例
     * @return true：在容器中只会保存一份；false：每次获取都会创建一个新的
     */
    @Override
    public boolean isSingleton() {
        return true;
    }
}
