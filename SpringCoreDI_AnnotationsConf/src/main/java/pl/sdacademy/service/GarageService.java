package pl.sdacademy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import pl.sdacademy.model.Worker;

@Component // - model
// @Service - logika biznesowa
// @Repository - zajmują się dostępem do danych, automatyczne tłumaczenie exception
// @Controllers - obsługa requestów w MVC
public class GarageService {
    private Worker worker;

    public Worker getWorker() {
        return worker;
    }

    @Autowired
    public void setWorker(@Qualifier("mechanic") Worker worker) {
        this.worker = worker;
    }
}
