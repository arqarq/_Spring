package pl.sdacademy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloSpringConfig {
    @Bean
    public HelloSpring helloSpring() {
        HelloSpring helloSpring = new HelloSpring();

        helloSpring.setWelcomeMessage("Hello Spring!!!");
        return helloSpring;
    }
}
