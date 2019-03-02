package pl.sdacademy.springjdbc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import pl.sdacademy.springjdbc.model.Flat;
import pl.sdacademy.springjdbc.model.Room;

import java.util.Arrays;
import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@Transactional
// @ContextConfiguration(classes = RepositoryConfig.class)
@ContextConfiguration(classes = SpringJdbcApplication.class)
public class FlatRepositoryTest {
    @Autowired
    FlatRepository flatRepository;

    @Test
    public void testFlatRepository() {
        Room room = new Room();
        room.setArea(100);
        room.setWindowsCount(6);

        Room room2 = new Room();
        room2.setArea(101);
        room2.setWindowsCount(5);

        Room room3 = new Room();
        room3.setArea(103);
        room3.setWindowsCount(4);

        Flat flat = new Flat("Wojewódzka 800");
        flat.setRooms(new HashSet<>(Arrays.asList(room, room2, room3)));
        flat.setArea(flat.giveArea());
        assertThat(flat.getArea()).isEqualTo(304);

        Flat flatSaved = flatRepository.save(flat);
        System.out.println("=== powierzchnia mieszkania: " + flat.getArea());
        System.out.println("=== Id mieszkania: " + flatSaved.getId());

        assertThat(flatRepository.findAll()).isNotEmpty();
        assertThat(flatRepository.returnRoomsCount()).isEqualTo(3);

        flatRepository.delete(flatSaved);
        assertThat(flatRepository.findAll()).isEmpty();
        assertThat(flatRepository.returnRoomsCount()).isZero();
    }
}
