package pl.sdacademy.springjpa.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.sdacademy.springjpa.model.Player;

import java.util.List;

public interface PlayerRepository extends CrudRepository<Player, Long> {
    List<Player> findByFirstName(String name);

    List<Player> findByLastName(String name);
}
