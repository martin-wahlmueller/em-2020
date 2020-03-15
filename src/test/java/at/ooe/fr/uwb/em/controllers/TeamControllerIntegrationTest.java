package at.ooe.fr.uwb.em.controllers;

import at.ooe.fr.uwb.em.dtos.TeamDto;
import at.ooe.fr.uwb.em.services.ITeamService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Collection;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(TeamController.class)
class TeamControllerIntegrationTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ITeamService teamService;

    @Test
    public void Get_team_by_id_should_return_team_dto() throws Exception {
        TeamDto team = new TeamDto(1, "austria");

        given(teamService.getTeamById(team.getId()))
                .willReturn(team);

        mvc.perform(get("/team/" + team.getId())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                        .andExpect(jsonPath("$.name").value(team.getName()));
    }

    @Test
    public void Get_teams_should_return_teams_dto() throws Exception {
        Collection<TeamDto> teams = new ArrayList<TeamDto>();
        teams.add(new TeamDto(1, "austria"));
        teams.add(new TeamDto(2, "italy"));
        Iterable<TeamDto> teamsIterable = teams;

        given(teamService.getAllTeams())
                .willReturn(teams);

        mvc.perform(get("/team")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].name").value("austria"))
                .andExpect(jsonPath("$[1].name").value("italy"));
    }
}
