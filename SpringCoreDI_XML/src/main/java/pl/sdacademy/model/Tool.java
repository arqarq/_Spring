package pl.sdacademy.model;

import org.springframework.beans.factory.InitializingBean;

public class Tool implements InitializingBean {
    private int weight;
    private String name;

    public Tool() {
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
        System.out.println("After properties set");
    }
}
