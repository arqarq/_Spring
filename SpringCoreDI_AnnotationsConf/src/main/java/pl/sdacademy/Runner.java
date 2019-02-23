package pl.sdacademy;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import pl.sdacademy.model.Tool;
import pl.sdacademy.model.Worker;
import pl.sdacademy.model.WorkerMotto;
import pl.sdacademy.service.GarageService;

public class Runner {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(RunnerConf.class);

        GarageService service = (GarageService) context.getBean("garageService");
        System.out.println(service.getWorker());

        System.out.println(context.getBeansOfType(Tool.class).size());
        System.out.println(context.getBeansOfType(Worker.class).size());
        System.out.println(context.getBeansOfType(WorkerMotto.class).size());
    }
}
