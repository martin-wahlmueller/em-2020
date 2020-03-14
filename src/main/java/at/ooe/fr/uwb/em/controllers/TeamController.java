package at.ooe.fr.uwb.em.controllers;

import at.ooe.fr.uwb.em.commands.CreateTeam;
import at.ooe.fr.uwb.em.dtos.TeamDto;
import at.ooe.fr.uwb.em.models.Team;
import at.ooe.fr.uwb.em.services.ITeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/team")
public class TeamController {

    @Autowired
    private ITeamService teamService;

    @GetMapping
    public @ResponseBody Iterable<TeamDto> getAllTeams() {
        return teamService.getAllTeams();
    }

    @GetMapping(value = "/{id}")
    public @ResponseBody TeamDto getTeamById(@PathVariable int id) {
        return teamService.getTeamById(id);
    }

    @PostMapping
    public @ResponseBody void addTeam(@RequestBody CreateTeam command) {
        teamService.createTeam(command);
    }
}
