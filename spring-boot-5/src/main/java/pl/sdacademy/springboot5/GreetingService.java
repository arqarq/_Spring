package pl.sdacademy.springboot5;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {
    String greeting() {
        return "Greeting from service";
    }
}
