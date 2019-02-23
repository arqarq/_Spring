package pl.sdacademy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pl.sdacademy.model.Tool;
import pl.sdacademy.model.Worker;
import pl.sdacademy.model.WorkerMotto;

public class Runner {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"beans.xml"});

        WorkerMotto motto = (WorkerMotto) context.getBean("wiseMotto");
        Tool hummer = (Tool) context.getBean("hummer");
        Tool hummer1 = (Tool) context.getBean("hummer");
        Tool hummer2 = (Tool) context.getBean("hummer");
        Worker worker = (Worker) context.getBean("worker");

        System.out.println(motto.getCitate());
        System.out.println(hummer);
        System.out.println(hummer1);
        System.out.println(hummer2);
        System.out.println(worker);
    }
}
