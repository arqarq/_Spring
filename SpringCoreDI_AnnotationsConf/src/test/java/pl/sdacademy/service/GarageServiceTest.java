package pl.sdacademy.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.sdacademy.model.Worker;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class GarageServiceTest {
    @Autowired
    ApplicationContext applicationContext;

    @Test
    public void shouldGarageService() {
        // Given
        Worker worker = (Worker) applicationContext.getBean("mechanik");
        // When
        String profession = worker.getProfession();
        // Then
        assertEquals(profession, "mechanikk");
    }
}
