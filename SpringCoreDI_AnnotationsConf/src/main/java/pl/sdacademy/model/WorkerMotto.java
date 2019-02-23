package pl.sdacademy.model;

import org.springframework.stereotype.Component;

@Component
public class WorkerMotto {
    private String citate;

    public WorkerMotto() {
    }

    public WorkerMotto(String citate) {
        this.citate = citate;
    }

    public String getCitate() {
        return citate;
    }

    public void setCitate(String citate) {
        this.citate = citate;
    }

    @Override
    public String toString() {
        return "WorkerMotto{" +
                "citate='" + citate + '\'' +
                '}';
    }
}
