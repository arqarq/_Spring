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

    public Flat(String address) {
        this.address = address;
    }

    public int giveArea() {
        int sum = 0;
        for (Room room : rooms) {
            sum += room.getArea();
        }
        return sum;
    }
}
