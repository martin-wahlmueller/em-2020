package at.ooe.fr.uwb.em.services.impl;

import at.ooe.fr.uwb.em.dtos.GroupDto;
import at.ooe.fr.uwb.em.models.Group;
import at.ooe.fr.uwb.em.repositories.IGroupRepository;
import at.ooe.fr.uwb.em.services.IGroupService;
import javassist.NotFoundException;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.Optional;

@Service
public class GroupService implements IGroupService {

    @Autowired
    private IGroupRepository groupRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Iterable<GroupDto> getAllGroups() {
        Iterable<Group> groups = groupRepository.findAll();
        Type listType = new TypeToken<Iterable<GroupDto>>() {}.getType();
        Iterable<GroupDto> groupDtoList = modelMapper.map(groups, listType);
        return groupDtoList;
    }

    @Override
    public GroupDto getGroupById(int id) throws NotFoundException {
        Optional<Group> optional = groupRepository.findById(id);
        if(optional.isPresent()) {
            return modelMapper.map(optional.get(), GroupDto.class);
        } else {
            throw new NotFoundException("entity not found");
        }
    }
}
