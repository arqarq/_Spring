package pl.sdacademy.springmongodb.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import pl.sdacademy.springmongodb.model.Car;

import java.util.List;

public interface CarRepository extends MongoRepository<Car, Long> {
    List<Car> findByBrand(@Param("brand") String brand);
}
