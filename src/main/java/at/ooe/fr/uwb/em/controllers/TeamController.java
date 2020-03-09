package at.ooe.fr.uwb.em.controllers;

import at.ooe.fr.uwb.em.commands.CreateTeam;
import at.ooe.fr.uwb.em.models.Team;
import at.ooe.fr.uwb.em.repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/team")
public class TeamController {

    @Autowired
    private TeamRepository teamRepository;

    @PostMapping
    public @ResponseBody void addTeam(@RequestBody CreateTeam command) {
        Team team = new Team();
        team.setName(command.getName());
        teamRepository.save(team);
    }

    @GetMapping
    public @ResponseBody Iterable<Team> getAllTeams() {
        return teamRepository.findAll();
    }
}
