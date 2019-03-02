package pl.sdacademy.springjpa.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.sdacademy.springjpa.model.Team;

public interface TeamRepository extends CrudRepository<Team, Long> {
}
