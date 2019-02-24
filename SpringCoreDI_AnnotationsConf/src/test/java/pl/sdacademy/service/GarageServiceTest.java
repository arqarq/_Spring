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
@ContextConfiguration(classes = {pl.sdacademy.RunnerConf.class})
public class GarageServiceTest {
    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void shouldGarageServiceWithBean() {
        // Given
        Worker worker = (Worker) applicationContext.getBean("mechanic");
        // When
        String profession = worker.getProfession();
        // Then
        assertEquals(profession, "mechanikk");
    }

    @Test
    public void shouldGarageServiceWithoutBean() {
        // Given
        Worker worker = (Worker) applicationContext.getBean("worker");
        // When
        String profession = worker.getProfession();
        // Then
        assertEquals(profession, "builder");
    }

    @Test
    public void shouldGarageServiceIsSingleton() {
        // Given
        Worker worker = (Worker) applicationContext.getBean("worker");
        Worker worker2 = (Worker) applicationContext.getBean("worker");
        // When
        // Then
        assertEquals(worker, worker2);
    }
}
