import com.study.config.AppConfig;
import com.study.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    public static void main(String[] args) {
//        //方法1：使用springAPI
//        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        //方法2：使用自定义类
//        ApplicationContext context = new ClassPathXmlApplicationContext("DiyAopContext.xml");
//        UserService userService = (UserService)context.getBean("userService");
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = context.getBean("getUserService",UserService.class);
        String add = userService.add();
        System.out.println(add);
//        userService.delete();
    }
}
