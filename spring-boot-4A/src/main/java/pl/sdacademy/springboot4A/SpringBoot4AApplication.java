package pl.sdacademy.springboot4A;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBoot4AApplication {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringBoot4AApplication.class, args);

        context.getBean("helloSpring", HelloSpring.class).helloSpring();
    }
}
