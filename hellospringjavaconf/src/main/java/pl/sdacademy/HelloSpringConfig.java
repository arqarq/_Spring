package pl.sdacademy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class HelloSpringConfig {
    @Bean
    public HelloSpring helloSpring() {
        HelloSpring helloSpring = new HelloSpring();

        helloSpring.setWelcomeMessage("Hello Spring!!!");
        return helloSpring;
    }

    @Bean
    @Scope("singleton") // domyślny
    public HelloSpring helloSingletonGreeter() {
        HelloSpring helloSpring = new HelloSpring();

        helloSpring.setWelcomeMessage("Hello from singleton!!!");
        return helloSpring;
    }

    @Bean
    @Scope("prototype")
    public HelloSpring helloPrototypeGreeter() {
        HelloSpring helloSpring = new HelloSpring();

        helloSpring.setWelcomeMessage("Hello from prototype!!!");
        return helloSpring;
    }
}
