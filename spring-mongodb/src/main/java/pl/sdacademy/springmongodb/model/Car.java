package pl.sdacademy.springmongodb.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document(collection = "cars")
public class Car {
    // private Long id;
    private String name;
    private String brand;
    private Integer capacity;
    private Integer hp;
}
