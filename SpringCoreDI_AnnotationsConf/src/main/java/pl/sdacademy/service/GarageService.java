package pl.sdacademy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import pl.sdacademy.model.Worker;

@Component
public class GarageService {
    private Worker worker;

    public Worker getWorker() {
        return worker;
    }

    @Autowired
    public void setWorker(@Qualifier("mechanik") Worker worker) {
        this.worker = worker;
    }
}
