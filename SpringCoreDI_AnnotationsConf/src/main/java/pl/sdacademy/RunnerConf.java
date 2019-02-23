package pl.sdacademy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import pl.sdacademy.model.Worker;

@Configuration
@ComponentScan
public class RunnerConf {
    @Bean
    public Worker mechanik() {
        Worker worker = new Worker();
        worker.setProfession("mechanikk");
        return worker;
    }
}
