package pl.sdacademy;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

import java.util.logging.Logger;

public class HelloSpringApp {
    private static final Logger logger = Logger.getLogger(HelloSpringApp.class.getName());

    public static void main(String[] args) {
//        ApplicationContext context = new AnnotationConfigApplicationContext(HelloSpringConfig.class);
        ApplicationContext context = SpringApplication.run(HelloSpringConfig.class);

        HelloSpring bean = (HelloSpring) context.getBean("helloSpring");
//        HelloSpring bean = context.getBean(HelloSpring.class);
        System.out.println(bean.getWelcomeMessage());

        HelloSpring beanS1 = (HelloSpring) context.getBean("helloSingletonGreeter");
        HelloSpring beanS2 = (HelloSpring) context.getBean("helloSingletonGreeter");
        System.out.println(beanS1.getWelcomeMessage());
        HelloSpring beanP1 = (HelloSpring) context.getBean("helloPrototypeGreeter");
        HelloSpring beanP2 = (HelloSpring) context.getBean("helloPrototypeGreeter");
        System.out.println(beanP1.getWelcomeMessage());

        System.out.println("comparing singletons: " + beanS1.equals(beanS2));
        System.out.println("comparing prototypes: " + beanP1.equals(beanP2));

        logger.info(String.format("====== %s", beanP2.getWelcomeMessage()));
    }
}
