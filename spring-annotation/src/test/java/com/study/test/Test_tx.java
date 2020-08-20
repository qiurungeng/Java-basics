package com.study.test;

import com.study.transaction.TxConfig;
import com.study.transaction.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test_tx {
    @Test
    public void test(){
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(TxConfig.class);
        UserService userService = context.getBean(UserService.class);
        userService.insertUser();
        context.close();
    }
}
