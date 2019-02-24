package pl.sdacademy.springboot5;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBoot5ApplicationTests {
    @Autowired
    private GreetingController greetingController;

    @Test
    public void contextLoads() {
    }

    @Test
    public void shouldBeanNotBeNull() {
        assertThat(greetingController).isNotNull();
    }
}
