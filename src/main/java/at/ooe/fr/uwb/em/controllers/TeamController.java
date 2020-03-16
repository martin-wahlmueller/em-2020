package at.ooe.fr.uwb.em.controllers;

import at.ooe.fr.uwb.em.dtos.TeamDto;
import at.ooe.fr.uwb.em.services.ITeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TeamController {

    @Autowired
    private ITeamService teamService;

    @GetMapping("/team")
    public String teams(Model model) {
        Iterable<TeamDto> teams = teamService.getAllTeams();
        model.addAttribute("teams", teams);
        return "teams";
    }
}
