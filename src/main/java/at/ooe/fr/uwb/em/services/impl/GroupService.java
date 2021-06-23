package at.ooe.fr.uwb.em.services.impl;

import at.ooe.fr.uwb.em.dtos.GroupDto;
import at.ooe.fr.uwb.em.models.Group;
import at.ooe.fr.uwb.em.repositories.IGroupRepository;
import at.ooe.fr.uwb.em.services.IGroupService;
import javassist.NotFoundException;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.Optional;

@Service
public class GroupService implements IGroupService {

    Logger logger = LoggerFactory.getLogger(GroupService.class);

    private final IGroupRepository groupRepository;

    private final ModelMapper modelMapper;

    public GroupService(IGroupRepository groupRepository, ModelMapper modelMapper) {
        this.groupRepository = groupRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Iterable<GroupDto> getAllGroups() {
        Iterable<Group> groups = groupRepository.findAll();
        Type listType = new TypeToken<Iterable<GroupDto>>() {}.getType();
        return modelMapper.map(groups, listType);
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
