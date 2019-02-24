package pl.sdacademy.springboot4A;

import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class HelloSpring {
    private static final Logger LOG = Logger.getLogger(SpringBoot4AApplication.class.getName());

    void helloSpring() {
        LOG.info("Hello Spring Boot! It’s awesome!");
    }
}
