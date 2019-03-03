package pl.sdacademy.springmongodb;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import pl.sdacademy.springmongodb.model.Car;
import pl.sdacademy.springmongodb.repositories.CarRepository;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringMongodbApplicationTests {
    @Autowired
    MongoTemplate mongoTemplate;
    @Autowired
    CarRepository carRepository;
    private Car car;

    @Test
    public void contextLoads() {
    }

    @Before
    public void init_() {
        mongoTemplate.dropCollection("cars");
        mongoTemplate.createCollection("cars");

        car = Car.builder()
                .brand("Enzo")
                .name("Fiatarri")
                .capacity(6500)
                .hp(200)
                .build();
        mongoTemplate.insert(car, "cars");

        car = Car.builder()
                .brand("Fiat")
                .name("500")
                .capacity(560)
                .hp(50)
                .build();
        mongoTemplate.insert(car, "cars");
    }

    @Test
    public void shouldTestMongoTemplate() {
        System.out.println("============= MongoTemplate");
        mongoTemplate.findAll(Car.class, "cars").forEach(doc -> System.out.println(doc.toString()));
    }

    @Test
    public void shouldTestCarRepository() {
        System.out.println("============= CarRepository");
        carRepository.findAll().forEach(doc -> System.out.println(doc.toString()));

        List<Car> all = carRepository.findAll();
        assertThat(all).isNotEmpty();
    }
}
