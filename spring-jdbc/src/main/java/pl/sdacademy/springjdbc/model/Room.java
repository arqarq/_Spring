package pl.sdacademy.springjdbc.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
class Room {
    @Id
    private Long id;
    private int area;
    private int windowsCount;
}
