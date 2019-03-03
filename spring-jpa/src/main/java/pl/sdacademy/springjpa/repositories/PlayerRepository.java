package pl.sdacademy.springjpa.repositories;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import pl.sdacademy.springjpa.model.Player;

import java.util.List;

public interface PlayerRepository extends CrudRepository<Player, Long>, QuerydslPredicateExecutor<Player> {
    List<Player> findByFirstName(String name);

    List<Player> findByLastName(String name);

    List<Player> findByAgeLessThan(int age);

    List<Player> findByAgeGreaterThan(int age);

    List<Player> findByAgeBetweenOrAgeEquals(int ageLower, int ageHigher, int exact);
}
