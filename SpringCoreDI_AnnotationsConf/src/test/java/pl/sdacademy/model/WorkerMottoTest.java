package pl.sdacademy.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {pl.sdacademy.RunnerConf.class})
public class WorkerMottoTest {
    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void shouldWorkerMottoBePrototype() {
        // Given
        WorkerMotto workerMotto = (WorkerMotto) applicationContext.getBean("workerMotto");
        WorkerMotto workerMotto2 = (WorkerMotto) applicationContext.getBean("workerMotto");
        // When
        // Then
        assertNotEquals(workerMotto, workerMotto2);
    }
}
