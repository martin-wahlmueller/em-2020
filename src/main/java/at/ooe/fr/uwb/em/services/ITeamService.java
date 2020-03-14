package at.ooe.fr.uwb.em.services;

import at.ooe.fr.uwb.em.commands.CreateTeam;
import at.ooe.fr.uwb.em.dtos.TeamDto;

import java.util.Collection;

public interface ITeamService {
    public abstract void createTeam(CreateTeam command);
    public abstract Collection<TeamDto> getAllTeams();
    public abstract TeamDto getTeamById(int id);
}
