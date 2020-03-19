package at.ooe.fr.uwb.em.services;

import at.ooe.fr.uwb.em.dtos.GroupDto;
import javassist.NotFoundException;

public interface IGroupService {
    Iterable<GroupDto> getAllGroups();
    GroupDto getGroupById(int id) throws NotFoundException;
}
