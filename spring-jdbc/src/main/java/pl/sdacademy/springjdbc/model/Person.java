package pl.sdacademy.springjdbc.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

@Data
@Builder
public class Person {
    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private Profession profession;
    private LocalDate dateOfBirth;
}
