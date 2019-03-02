package pl.sdacademy.springjpa;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.sdacademy.springjpa.model.Player;
import pl.sdacademy.springjpa.model.Team;
import pl.sdacademy.springjpa.repositories.PlayerRepository;
import pl.sdacademy.springjpa.repositories.TeamRepository;

import java.util.Arrays;
import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringJpaApplicationTests {
    @Autowired
    PlayerRepository playerRepository;
    @Autowired
    TeamRepository teamRepository;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testAddPlayers() {
        Player player = new Player();
        player.setFirstName("Arek");
        player.setLastName("Sekuła");

        Player player2 = new Player();
        player2.setFirstName("Marek");
        player2.setLastName("Sontag");

        Team team = new Team();
        team.setDiscipline("NBA");
        team.setPlayers(new HashSet<>(Arrays.asList(player, player2)));

        playerRepository.save(player);
        playerRepository.save(player2);
        teamRepository.save(team);

        assertThat(playerRepository.count()).isEqualTo(2);
        assertThat(teamRepository.count()).isOne();

        // Method method = playerRepository.getClass().getMethods()[1];
        // method.setAccessible(true);
        // System.out.format("========== %s ===========", method.getName());
        // System.out.println();
        // System.out.format("========== %s ===========%n", playerRepository.getClass().getName());

        assertThat(playerRepository.findByFirstName("Arek").size()).isNotZero();
        assertThat(playerRepository.findByFirstName("Aek").size()).isZero();
    }

    @Test
    public void testDeletePlayers() {
        System.out.println(playerRepository.findAll());
        System.out.println(teamRepository.findAll());
    }
}
