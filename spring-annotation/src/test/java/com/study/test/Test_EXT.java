package com.study.test;

import com.study.ext.ExtConfig;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test_EXT {
    @Test
    public void test(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ExtConfig.class);
        context.close();
    }
}
