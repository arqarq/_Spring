package pl.sdacademy.springboot5;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {
    private String message;

    GreetingService() {
        this.message = "Greeting from service";
    }

    String greeting() {
        return message;
    }
}
