package at.ooe.fr.uwb.em.api;

import at.ooe.fr.uwb.em.dtos.GroupDto;
import at.ooe.fr.uwb.em.services.IGroupService;
import javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/group")
public class GroupApiController {

    private final IGroupService groupService;

    public GroupApiController(IGroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping
    public @ResponseBody ResponseEntity<Iterable<GroupDto>> getAllGroups() {
        return new ResponseEntity<>(groupService.getAllGroups(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public @ResponseBody ResponseEntity<GroupDto> getTeamById(@PathVariable int id) {
        try {
            return new ResponseEntity<>(groupService.getGroupById(id), HttpStatus.OK);
        } catch (NotFoundException exception)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
