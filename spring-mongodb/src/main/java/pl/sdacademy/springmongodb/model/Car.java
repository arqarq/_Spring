package pl.sdacademy.springmongodb.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Car {
    // private Long id;
    private String name;
    private String brand;
    private Integer capacity;
    private Integer hp;
}
