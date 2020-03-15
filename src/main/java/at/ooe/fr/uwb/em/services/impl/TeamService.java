package at.ooe.fr.uwb.em.services.impl;

import at.ooe.fr.uwb.em.commands.CreateTeam;
import at.ooe.fr.uwb.em.dtos.TeamDto;
import at.ooe.fr.uwb.em.models.Team;
import at.ooe.fr.uwb.em.repositories.ITeamRepository;
import at.ooe.fr.uwb.em.services.ITeamService;
import javassist.NotFoundException;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.Optional;

@Service
public class TeamService implements ITeamService {

    @Autowired
    private ITeamRepository teamRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Iterable<TeamDto> getAllTeams() {
        Iterable<Team> teams = teamRepository.findAll();
        Type listType = new TypeToken<Iterable<TeamDto>>() {}.getType();
        Iterable<TeamDto> teamDtoList = modelMapper.map(teams, listType);
        return teamDtoList;
    }

    @Override
    public TeamDto getTeamById(Integer id) throws NotFoundException {
        Optional<Team> optional = teamRepository.findById(id);
        if(optional.isPresent()) {
            return modelMapper.map(optional.get(), TeamDto.class);
        } else {
            throw new NotFoundException("entity not found");
        }
    }

    @Override
    public void createTeam(CreateTeam command) {
        Team team = modelMapper.map(command, Team.class);
        teamRepository.save(team);
    }
}
