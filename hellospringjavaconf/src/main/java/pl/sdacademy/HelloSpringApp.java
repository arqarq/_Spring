package pl.sdacademy;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

public class HelloSpringApp {
    public static void main(String[] args) {
//        ApplicationContext context = new AnnotationConfigApplicationContext(HelloSpringConfig.class);
        ApplicationContext context = SpringApplication.run(HelloSpringConfig.class);

//        HelloSpring bean = (HelloSpring) context.getBean("helloSpring");
        HelloSpring bean = context.getBean(HelloSpring.class);
        System.out.println(bean.getWelcomeMessage());
    }
}
