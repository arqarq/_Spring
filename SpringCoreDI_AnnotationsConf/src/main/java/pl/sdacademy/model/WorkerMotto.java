package pl.sdacademy.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
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
