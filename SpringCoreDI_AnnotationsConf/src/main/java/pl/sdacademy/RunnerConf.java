package pl.sdacademy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import pl.sdacademy.model.Tool;
import pl.sdacademy.model.Worker;

@Configuration
@ComponentScan
public class RunnerConf {
    @Bean
    public Worker mechanic() {
        Worker worker = new Worker();
        worker.setProfession("mechanikk");
        worker.setAge(20);
        return worker;
    }

    @Bean
    public Tool hummer() {
        return new Tool(5, "Młoteczek");
    }
}
