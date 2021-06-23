package at.ooe.fr.uwb.em.services.impl;

import at.ooe.fr.uwb.em.commands.CreateTeam;
import at.ooe.fr.uwb.em.dtos.TeamDto;
import at.ooe.fr.uwb.em.models.Team;
import at.ooe.fr.uwb.em.repositories.ITeamRepository;
import at.ooe.fr.uwb.em.services.ITeamService;
import javassist.NotFoundException;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.Optional;

@Service
public class TeamService implements ITeamService {

    Logger logger = LoggerFactory.getLogger(TeamService.class);

    private final ITeamRepository teamRepository;

    private final ModelMapper modelMapper;

    public TeamService(ITeamRepository teamRepository, ModelMapper modelMapper) {
        this.teamRepository = teamRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Iterable<TeamDto> getAllTeams() {
        Iterable<Team> teams = teamRepository.findAll();
        Type listType = new TypeToken<Iterable<TeamDto>>() {}.getType();
        return modelMapper.map(teams, listType);
    }

    @Override
    public TeamDto getTeamById(int id) throws NotFoundException {
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
