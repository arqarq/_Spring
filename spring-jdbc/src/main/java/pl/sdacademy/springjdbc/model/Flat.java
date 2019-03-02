package pl.sdacademy.springjdbc.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Set;

@Data
public class Flat {
    @Id
    private Long id;
    private Set<Room> rooms;
    private String address;
    private int area;
}
