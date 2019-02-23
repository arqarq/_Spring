package pl.sdacademy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("beans.xml");
        HelloSpring bean = (HelloSpring) context.getBean("helloSpring");

        System.out.println(bean.getWelcomeMessage());
    }
}
