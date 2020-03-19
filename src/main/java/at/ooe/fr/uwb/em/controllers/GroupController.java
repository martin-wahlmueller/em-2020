package at.ooe.fr.uwb.em.controllers;

import at.ooe.fr.uwb.em.dtos.GroupDto;
import at.ooe.fr.uwb.em.services.IGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GroupController {

    @Autowired
    private IGroupService groupService;

    @GetMapping("/group")
    public String teams(Model model) {
        Iterable<GroupDto> groups = groupService.getAllGroups();
        model.addAttribute("groups", groups);
        return "groups";
    }
}
