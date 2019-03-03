package pl.sdacademy.springmongodb;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
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
        mongoTemplate.createCollection("cars");

        car = Car.builder()
                .brand("Fiatarri")
                .name("Enzo")
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

        car = Car.builder()
                .brand("Peugeot")
                .name("407")
                .capacity(1597)
                .hp(110)
                .build();
        mongoTemplate.insert(car, "cars");
    }

    @After
    public void end_() {
        mongoTemplate.dropCollection("cars");
    }

    @Test
    public void shouldTestMongoTemplate() {
        System.out.println("============= MongoTemplate");
        List<Car> cars = mongoTemplate.findAll(Car.class, "cars");
        cars.forEach(doc -> System.out.println(doc.toString()));

        Query query = new Query().addCriteria(Criteria.where("brand").is("Fiat"));
        List<Car> foundDocs = mongoTemplate.find(query, Car.class);
        assertThat(foundDocs.size()).isOne();
        assertThat(mongoTemplate.count(query, "cars")).isOne();

        foundDocs = mongoTemplate.findAll(Car.class);
        assertThat(foundDocs.size()).isEqualTo(3);

        query = new Query().addCriteria(Criteria.where("brand").regex("Fiat.*"));
        foundDocs = mongoTemplate.find(query, Car.class);
        assertThat(foundDocs.size()).isEqualTo(2);

        Query queryToDel = new Query().addCriteria(Criteria.where("brand").regex("Fiatarri"));
        mongoTemplate.remove(queryToDel, Car.class);
        assertThat(mongoTemplate.count(query, "cars")).isOne();
        foundDocs = mongoTemplate.find(query, Car.class);
        assertThat(foundDocs.size()).isOne();
    }

    @Test
    @Ignore
    public void testDeleteInMongoDB() {
    }

    @Test
    public void shouldTestCarRepository() {
        System.out.println("============= CarRepository");
        carRepository.findAll().forEach(doc -> System.out.println(doc.toString()));

        List<Car> all = carRepository.findAll();
        assertThat(all).isNotEmpty();
    }
}
