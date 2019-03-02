package pl.sdacademy.springjpa.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class Team {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String discipline;
    @OneToMany/*(fetch = FetchType.EAGER)*/
    private Set<Player> players;
}
