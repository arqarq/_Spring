package pl.sdacademy.springjdbc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import pl.sdacademy.springjdbc.model.Person;
import pl.sdacademy.springjdbc.model.Profession;

import java.time.LocalDate;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@Transactional
@ContextConfiguration(classes = SpringJdbcApplication.class)
// @PropertySource("classpath:application-test.properties")
// @SpringBootTest
public class PersonRepositoryTest {
    @Autowired
    PersonRepository personRepository;

    @Test
    public void createSimplePersonTest() {
        // Given
        Person person = Person.builder()
                .firstName("Arek")
                .lastName("Sekuła")
                .dateOfBirth(LocalDate.of(1981, 1, 7))
                .profession(Profession.F1_DRIVER)
                .build();
        // When
        Person saved = personRepository.save(person);
        // Then
        assertThat(saved.getId()).isNotNull();
        assertThat(saved.getFirstName()).isEqualTo("Arek");
        assertThat(saved.getLastName()).isEqualTo("Sekuła");
        assertThat(saved.getProfession()).isEqualTo(Profession.F1_DRIVER);
        assertThat(saved.getDateOfBirth()).isEqualTo(LocalDate.of(1981, 1, 7));
    }

    @Test
    public void createWriterPersonTest() {
        // Given
        Person person = Person.builder()
                .firstName("Arek")
                .lastName("Sekuła")
                .dateOfBirth(LocalDate.of(1981, 1, 7))
                .profession(Profession.WRITER)
                .build();
        // When
        personRepository.save(person);
        // Then
        assertThat(personRepository.countWriters()).isOne();
    }

    @Test
    public void modifyPersonTest() {
        Person person = Person.builder()
                .firstName("John")
                .lastName("Tolkien")
                .dateOfBirth(LocalDate.of(1892, 1, 3))
                .profession(Profession.WRITER)
                .build();

        Person saved = personRepository.save(person);

        saved.setFirstName("Michael");
        saved.setLastName("Schumacher");
        saved.setDateOfBirth(LocalDate.of(1969, 1, 3));
        saved.setProfession(Profession.F1_DRIVER);

        personRepository.save(saved);

        Optional<Person> found = personRepository.findById(saved.getId());

        assertThat(found).isNotEmpty();
        assertThat(found.get().getId()).isEqualTo(saved.getId());
        assertThat(found.get().getFirstName()).isEqualTo("Michael");
        assertThat(found.get().getLastName()).isEqualTo("Schumacher");
        assertThat(found.get().getProfession()).isEqualTo(Profession.F1_DRIVER);
    }
}
