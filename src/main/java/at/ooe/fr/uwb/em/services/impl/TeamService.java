package at.ooe.fr.uwb.em.services.impl;

import at.ooe.fr.uwb.em.commands.CreateTeam;
import at.ooe.fr.uwb.em.dtos.TeamDto;
import at.ooe.fr.uwb.em.models.Team;
import at.ooe.fr.uwb.em.repositories.TeamRepository;
import at.ooe.fr.uwb.em.services.ITeamService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class TeamService implements ITeamService {

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Collection<TeamDto> getAllTeams() {
        Iterable<Team> teams = teamRepository.findAll();
        List<TeamDto> teamDtoList = new ArrayList<TeamDto>();
        for(Team team : teams) {
            TeamDto teamDto = modelMapper.map(team, TeamDto.class);
            teamDtoList.add(teamDto);
        }
        return teamDtoList;
    }

    @Override
    public TeamDto getTeamById(int id) {
        Team team = teamRepository.findById(id).get();
        return modelMapper.map(team, TeamDto.class);
    }

    @Override
    public void createTeam(CreateTeam command) {
        Team team = modelMapper.map(command, Team.class);
        teamRepository.save(team);
    }
}
