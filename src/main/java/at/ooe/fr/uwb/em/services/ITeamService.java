package at.ooe.fr.uwb.em.services;

import at.ooe.fr.uwb.em.commands.CreateTeam;
import at.ooe.fr.uwb.em.dtos.TeamDto;
import javassist.NotFoundException;

public interface ITeamService {
    void createTeam(CreateTeam command);
    Iterable<TeamDto> getAllTeams();
    TeamDto getTeamById(Integer id) throws NotFoundException;
}
