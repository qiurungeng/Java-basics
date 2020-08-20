package com.study.config;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportSelector implements ImportSelector {
    /**
     * 自定义返回需要的组件
     * @param annotationMetadata 当前@Import注解所标注类的所有注解信息
     * @return 返回值就是要导入到容器中组件的全类目，不能返回null
     */
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        return new String[]{"com.study.bean.Blue","com.study.bean.Green","com.study.bean.Yellow"};
    }
}
