package pl.sdacademy;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import pl.sdacademy.model.Tool;
import pl.sdacademy.model.Worker;
import pl.sdacademy.model.WorkerMotto;
import pl.sdacademy.service.GarageService;

import java.util.logging.Logger;

public class Runner {
    private static final Logger LOG = Logger.getLogger(Runner.class.getName());

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(RunnerConf.class);

        LOG.info("============================================");

        GarageService service = (GarageService) context.getBean("garageService");
        LOG.info(service.getWorker().toString());

        WorkerMotto motto = context.getBean(WorkerMotto.class);
        LOG.info(motto.getCitate());

        Worker defaultWorker = context.getBean("worker", Worker.class);
        defaultWorker.setMotto(context.getBean("wiseMotto", WorkerMotto.class));
        LOG.info(defaultWorker.getProfession());
        LOG.info(defaultWorker.getMotto().toString());

        LOG.info("Tools count: " + context.getBeansOfType(Tool.class).size());
        LOG.info("Worker count: " + context.getBeansOfType(Worker.class).size());
        LOG.info("Motto count: " + context.getBeansOfType(WorkerMotto.class).size());
    }
}
