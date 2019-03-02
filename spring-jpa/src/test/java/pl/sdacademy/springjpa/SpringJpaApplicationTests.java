package pl.sdacademy.springjpa;

import org.junit.Before;
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
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringJpaApplicationTests {
    @Autowired
    PlayerRepository playerRepository;
    @Autowired
    TeamRepository teamRepository;
    private Player player = new Player();
    private Player player2 = new Player();
    private Player player3 = new Player();
    private Player player4 = new Player();
    private Team team = new Team();
    private Team team2 = new Team();

    @Before
    public void init_() {
        player.setFirstName("Arek");
        player.setLastName("Sekuła");
        player.setAge(38);

        player2.setFirstName("Marek");
        player2.setLastName("Sontag");

        player3.setFirstName("Arek2");
        player3.setLastName("Sekuła2");
        player3.setAge(381);

        player4.setFirstName("Arek3");
        player4.setLastName("Sekuła4");
        player4.setAge(382);

        team.setDiscipline("NBA");
        team.setPlayers(new HashSet<>(Arrays.asList(player, player2)));
    }

    @Test
    public void contextLoads() {
    }

    @Test
    public void testAddPlayers() {
        System.out.println("============== ilość obiektów <Player> w bazie: " + playerRepository.count());
        playerRepository.save(player);
        System.out.println("============== ilość obiektów <Player> w bazie: " + playerRepository.count());
        playerRepository.save(player2);
        System.out.println("============== ilość obiektów <Player> w bazie: " + playerRepository.count());
        teamRepository.save(team);
        System.out.println("----========== ilość obiektów <Player> w bazie: " + playerRepository.count());

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

        long index = 3L;
        Team tempTeam = null;
        playerRepository.save(player3);
        playerRepository.save(player4);
        if (teamRepository.existsById(index)) {
            System.out.println("============== index <Team> w bazie: " + index);
            Optional<Team> teamById = teamRepository.findById(index);
            if (teamById.isPresent()) {
                teamById.get().addPlayer(player3);
                // teamById.get().addPlayer(player4);
                tempTeam = teamRepository.save(teamById.get());
            }
        }
        // team.addPlayer(player3);
        // team.addPlayer(player4);
        // teamRepository.save(team);

        assertThat(teamRepository.count()).isOne();
        if (tempTeam != null) {
            teamRepository.delete(tempTeam);
        }
        assertThat(teamRepository.count()).isZero();
        System.out.println("============== ilość obiektów <Player> w bazie: " + playerRepository.count());
        // assertThat(playerRepository.count()).isOne();
    }
}
