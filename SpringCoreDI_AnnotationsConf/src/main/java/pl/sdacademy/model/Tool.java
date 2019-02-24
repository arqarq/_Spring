package pl.sdacademy.model;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import pl.sdacademy.Runner;

import java.util.logging.Logger;

@Component
public class Tool implements InitializingBean {
    private static final Logger LOG = Logger.getLogger(Runner.class.getName());

    private int weight;
    private String name;

    public Tool() {
        this.weight = 1;
        this.name = "Just a tool";
    }

    public Tool(int weight, String name) {
        this.weight = weight;
        this.name = name + (int) (Math.random() * 100);
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Tool{" +
                "weight=" + weight +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        LOG.info("Tool after properties set");
    }
}
