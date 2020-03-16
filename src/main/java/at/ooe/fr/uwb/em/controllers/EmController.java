package at.ooe.fr.uwb.em.controllers;

import at.ooe.fr.uwb.em.dtos.TeamDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EmController {

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

    @GetMapping("/teams")
    public String teams(Model model) {
        List<TeamDto> teams = new ArrayList<TeamDto>();
        teams.add(new TeamDto(1, "austria"));
        teams.add(new TeamDto(2, "italy"));
        teams.add(new TeamDto(3, "france"));
        model.addAttribute("teams", teams);
        return "teams";
    }
}
