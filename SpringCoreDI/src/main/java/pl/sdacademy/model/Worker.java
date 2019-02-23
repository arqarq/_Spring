package pl.sdacademy.model;

import java.util.List;

public class Worker {
    private String profession;
    private int age;
    private List<Tool> tools;
    private WorkerMotto motto;

    public Worker() {
    }

    public Worker(String profession, int age, List<Tool> tools, WorkerMotto motto) {
        this.profession = profession;
        this.age = age;
        this.tools = tools;
        this.motto = motto;
    }

    public List<Tool> getTools() {
        return tools;
    }

    public void setTools(List<Tool> tools) {
        this.tools = tools;
    }

    public WorkerMotto getMotto() {
        return motto;
    }

    public void setMotto(WorkerMotto workerMotto) {
        this.motto = workerMotto;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "profession='" + profession + '\'' +
                ", age=" + age +
                ", tools=" + tools +
                ", motto=" + motto +
                '}';
    }

    private void addDefaultTool() {
        tools.add(new Tool(1, profession + "-tool"));
    }
}
