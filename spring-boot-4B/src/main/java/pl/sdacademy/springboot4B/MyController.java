package pl.sdacademy.springboot4B;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class MyController {
    private static final Logger LOG = Logger.getLogger(SpringBoot4BApplication.class.getName());

    @RequestMapping("/")
    @ResponseBody
    @ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
    public String printHello() {
        LOG.info("Hello Spring Boot! It’s really awesome!");
        return "Hello Spring Boot! It’s really awesome!";
    }
}
