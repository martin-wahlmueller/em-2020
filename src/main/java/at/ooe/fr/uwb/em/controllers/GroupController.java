package at.ooe.fr.uwb.em.controllers;

import at.ooe.fr.uwb.em.dtos.GroupDto;
import at.ooe.fr.uwb.em.services.IGroupService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GroupController {

    Logger logger = LoggerFactory.getLogger(GroupController.class);

    private final IGroupService groupService;

    public GroupController(IGroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping("/group")
    public String teams(Model model) {
        Iterable<GroupDto> groups = groupService.getAllGroups();
        model.addAttribute("groups", groups);
        return "groups";
    }
}
