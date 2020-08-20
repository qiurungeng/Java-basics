package spring.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.service.UserService;
import spring.service.UserServiceImpl;
import spring.dao.UserMyBatisDaoImpl;
import spring.pojo.People;
import spring.pojo.Student;

public class UserController {

    public static void main(String[] args) {

        /************************************************************
         * 控制反转，不再由Service自身提供Dao实现，而由调用Service的人提供Dao
         * 不再由餐厅自己预备食材，而由顾客带食材来给餐厅加工。
         * 系统的耦合性大大降低，可以更专注在业务的实现上
         */
//        TestIoc1();
//        TestIoc2();
//        TestInjection();
        testAutowired();
    }

    private static void testAutowired(){
        ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
        People people = context.getBean("people",People.class);
        people.getCat().shout();
        people.getDog().shout();
    }

    private static void TestInjection() {
        //注入
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Student student = (Student) context.getBean("student");
        System.out.println(student.toString());
        //Student{name='憨批',
        // address=Address{address='null'},
        // books=[书1, 书2, 书3, 书1], hobbies=[爱好1, 爱好2, 爱好3, 爱好4],
        // card={身份证=12341324, 学生证=423423423}, games=[DNF, LOL, CBA],
        // wife='null', info={学号=20170000, 性别=男, 姓名=奭}}
    }

    private static void TestIoc2() {
        //依靠IOC容器
        ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
        UserService userService=(UserServiceImpl)context.getBean("userServiceImpl");
        UserService userService2=(UserServiceImpl)context.getBean("userServiceImpl");
        System.out.println(userService.getUser());
        System.out.println("判断容器中两次取出的对象是否相同(userService1==userService2)："+(userService==userService2));
    }

    private static void TestIoc1() {
        //不依靠Spring容器，最简单的Ioc、DI思想
        UserService userService=new UserServiceImpl();
        ((UserServiceImpl)userService).setUserDao(new UserMyBatisDaoImpl());
        String userData=userService.getUser();
        System.out.println(userData);
    }
}
