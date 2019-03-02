package pl.sdacademy.springjdbc;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import pl.sdacademy.springjdbc.model.Flat;

public interface FlatRepository extends CrudRepository<Flat, Long> {
    @Query("SELECT count(*) FROM room")
    int returnRoomsCount();
}
