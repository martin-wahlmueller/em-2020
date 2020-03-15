package at.ooe.fr.uwb.em.services;

import at.ooe.fr.uwb.em.dtos.TeamDto;
import at.ooe.fr.uwb.em.models.Team;
import at.ooe.fr.uwb.em.repositories.ITeamRepository;
import at.ooe.fr.uwb.em.services.impl.TeamService;
import javassist.NotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
class TeamServiceIntegrationTest {
    @Autowired
    private TeamService teamService;

    @MockBean
    private ITeamRepository teamRepository;

    @MockBean
    private ModelMapper modelMapper;

    @Test
    public void Find_by_id_should_return_team() throws NotFoundException {
        //GIVEN
        Team team = new Team(1, "austria");

        Mockito.when(modelMapper.map(Mockito.any(), Mockito.any()))
                .thenReturn(new TeamDto(team.getId(), team.getName()));
        Mockito.when(teamRepository.findById(Mockito.anyInt()))
                .thenReturn(Optional.of(team));

        //WHEN
        TeamDto found = teamService.getTeamById(team.getId());

        //THEN
        assertThat(found).isNotNull();
        assertThat(found.getId()).isEqualTo(team.getId());
    }

    @Test
    public void Get_all_should_return_teams() {
        //GIVEN
        Collection<Team> teams = new ArrayList<Team>();
        teams.add(new Team(1, "austria"));
        teams.add(new Team(2, "italy"));
        Iterable<Team> teamsIterable = teams;

        Collection<TeamDto> teamsDto = new ArrayList<TeamDto>();
        for(Team team : teamsIterable) {
            teamsDto.add(new TeamDto(team.getId(), team.getName()));
        }
        Iterable<TeamDto> teamsDtoIterable = teamsDto;

        Mockito.when(teamRepository.findAll())
                .thenReturn(teamsIterable);
        Mockito.when(modelMapper.map(Mockito.anyIterable(), Mockito.any(Type.class)))
                .thenReturn(teamsDtoIterable);

        //WHEN
        Iterable<TeamDto> found = teamService.getAllTeams();

        //THEN
        Collection<TeamDto> foundCollection = new ArrayList<TeamDto>();
        Iterator<TeamDto> iterator = found.iterator();
        while(iterator.hasNext()) {
            foundCollection.add(iterator.next());
        }

        assertThat(foundCollection.size()).isEqualTo(teams.size());
        assertThat(found).isEqualTo(teamsDto);
    }
}
