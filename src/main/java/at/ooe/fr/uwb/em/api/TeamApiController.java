package at.ooe.fr.uwb.em.api;

import at.ooe.fr.uwb.em.commands.CreateTeam;
import at.ooe.fr.uwb.em.dtos.TeamDto;
import at.ooe.fr.uwb.em.services.ITeamService;
import javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/team")
public class TeamApiController {

    private final ITeamService teamService;

    public TeamApiController(ITeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping
    public @ResponseBody ResponseEntity<Iterable<TeamDto>> getAllTeams() {
        return new ResponseEntity<>(teamService.getAllTeams(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public @ResponseBody ResponseEntity<TeamDto> getTeamById(@PathVariable int id) {
        try {
            return new ResponseEntity<>(teamService.getTeamById(id), HttpStatus.OK);
        } catch (NotFoundException exception) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public @ResponseBody void addTeam(@RequestBody CreateTeam command) {
        teamService.createTeam(command);
    }
}
