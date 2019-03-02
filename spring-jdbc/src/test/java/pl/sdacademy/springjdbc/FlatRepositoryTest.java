package pl.sdacademy.springjdbc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

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
        assertThat(false).isFalse();
    }
}
