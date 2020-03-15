package at.ooe.fr.uwb.em.repositories;

import at.ooe.fr.uwb.em.models.Team;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
class TeamRepositoryIntegrationTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ITeamRepository teamRepository;

    @Test
    public void Find_by_id_should_return_team() {
        //GIVEN
        Team team = new Team("austria");
        team = entityManager.persistAndFlush(team);

        //WHEN
        Team found = teamRepository.findById(team.getId()).get();

        //THEN
        assertThat(found.getId()).isEqualTo(team.getId());
    }

    @Test
    public void Find_all_should_return_teams() {
        //GIVEN
        Collection<Team> teams = new ArrayList<Team>();
        teams.add(new Team("austria"));
        teams.add(new Team("italy"));
        Iterable<Team> teamsIterable = teams;
        for(Team team : teams) {
            entityManager.persist(team);
        }
        entityManager.flush();

        //WHEN
        Iterable<Team> found = teamRepository.findAll();

        //THEN
        Iterator<Team> iterator = found.iterator();
        Collection<Team> foundCollection = new ArrayList<Team>();
        while(iterator.hasNext()) {
            foundCollection.add(iterator.next());
        }

        assertThat(foundCollection.size()).isEqualTo(teams.size());
        assertThat(teamsIterable).isEqualTo(found);
    }
}
