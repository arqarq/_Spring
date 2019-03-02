package pl.sdacademy.springjdbc;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import pl.sdacademy.springjdbc.model.Person;

public interface PersonRepository extends CrudRepository<Person, Long> {
    @Query("SELECT count(*) FROM person WHERE profession = 'WRITER'")
    int countWriters();
}
