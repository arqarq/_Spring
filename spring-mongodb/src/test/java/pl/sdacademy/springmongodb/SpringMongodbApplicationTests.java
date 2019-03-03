package pl.sdacademy.springmongodb;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import pl.sdacademy.springmongodb.model.Car;
import pl.sdacademy.springmongodb.repositories.CarRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringMongodbApplicationTests {
    @Autowired
    MongoTemplate mongoTemplate;
    @Autowired
    CarRepository carRepository;

    @Test
    public void contextLoads() {
    }

    @Test
    public void shouldTestMongoTemplate() {
        Car car = Car.builder()
                .brand("Fiat")
                .name("Fiatarri")
                .capacity(6500)
                .hp(200)
                .build();
        mongoTemplate.insert(car);
        System.out.println("=============");
        mongoTemplate.findAll(Car.class).forEach(obj -> System.out.println(obj.toString()));
    }

    @Test
    public void shouldTestCarRepository() {
        // Given
        // When
        // Then
    }
}
