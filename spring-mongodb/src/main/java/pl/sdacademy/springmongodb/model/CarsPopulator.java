package pl.sdacademy.springmongodb.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;
import pl.sdacademy.springmongodb.repositories.CarRepository;

@Component
public class CarsPopulator implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(CarsPopulator.class);
    @Autowired
    CarRepository carRepository;
    @Autowired
    MongoTemplate mongoTemplate;

    // @Override
    public void run(String... args) throws Exception {
        mongoTemplate.dropCollection("cars"); // lub
        carRepository.deleteAll();

        Car car = Car.builder()
                .id(1L)
                .brand("Ferrari")
                .name("812 Superfast")
                .hp(800)
                .capacity(6500)
                .build();
        Car car2 = Car.builder()
                .id(2L)
                .brand("Fiat")
                .name("126p")
                .hp(23)
                .capacity(650)
                .build();
        Car car3 = Car.builder()
                .id(3L)
                .brand("Fiatt")
                .name("126pp")
                .hp(233)
                .capacity(7500)
                .build();

        carRepository.insert(car);
        carRepository.insert(car2);
        carRepository.insert(car3);

        logger.info("Powiedz coś tu");
    }
}
