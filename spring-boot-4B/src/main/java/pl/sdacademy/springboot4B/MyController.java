package pl.sdacademy.springboot4B;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class MyController {
    private static final Logger LOG = Logger.getLogger(SpringBoot4BApplication.class.getName());

    @RequestMapping("/")
    public void printHello() {
        LOG.info("Hello Spring Boot! It’s really awesome!");
    }
}
