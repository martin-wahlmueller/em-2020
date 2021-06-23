package at.ooe.fr.uwb.em.controllers;

import at.ooe.fr.uwb.em.dtos.TeamDto;
import at.ooe.fr.uwb.em.services.ITeamService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TeamController {

    Logger logger = LoggerFactory.getLogger(TeamController.class);

    private final ITeamService teamService;

    public TeamController(ITeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping("/team")
    public String teams(Model model) {
        Iterable<TeamDto> teams = teamService.getAllTeams();
        model.addAttribute("teams", teams);
        return "teams";
    }
}
