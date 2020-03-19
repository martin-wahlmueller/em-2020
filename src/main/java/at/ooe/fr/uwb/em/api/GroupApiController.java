package at.ooe.fr.uwb.em.api;

import at.ooe.fr.uwb.em.dtos.GroupDto;
import at.ooe.fr.uwb.em.services.IGroupService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/group")
public class GroupApiController {

    @Autowired
    private IGroupService groupService;

    @GetMapping
    public @ResponseBody ResponseEntity<Iterable<GroupDto>> getAllGroups() {
        return new ResponseEntity(groupService.getAllGroups(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public @ResponseBody ResponseEntity<GroupDto> getTeamById(@PathVariable int id) {
        try {
            return new ResponseEntity(groupService.getGroupById(id), HttpStatus.OK);
        } catch (NotFoundException exception)
        {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
