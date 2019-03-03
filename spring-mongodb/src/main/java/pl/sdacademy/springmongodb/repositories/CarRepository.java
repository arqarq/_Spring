package pl.sdacademy.springmongodb.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import pl.sdacademy.springmongodb.model.Car;

public interface CarRepository extends MongoRepository<Car, Long> {
}
