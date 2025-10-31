package dev.vorstu.services;

import dev.vorstu.dto.GroupDto;
import dev.vorstu.dto.GroupMapping;
import dev.vorstu.dto.UserDto;
import dev.vorstu.dto.UserMapping;
import dev.vorstu.entity.Group;
import dev.vorstu.entity.User;
import dev.vorstu.enums.Role;
import dev.vorstu.repositories.GroupRepository;
import dev.vorstu.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BaseService {

    private final UserRepository userRepository;
    private final UserMapping userMapping;
    private final GroupRepository groupRepository;
    private final GroupMapping groupMapping;

    public Page<UserDto> getStudentsWithPagination(Long id, int page, int size, String name, String sort){
        User user = userRepository.findById(id).orElse(null);

        String groupName = user.getGroups().getGroupName();

        String[] parts = sort.split(",");
        String field = parts[0];
        Sort.Direction direction = Sort.Direction.fromString(parts[1].toUpperCase());
        if (field.equals("group")) {
            field = "groups.groupName";
        }

        if(user.getRole() == Role.ADMIN){
            return userRepository.findAllStudentsByNameContains(name, PageRequest.of(page, size, Sort.by(direction, field)))
                    .map(userMapping::toDto);
        }
        else{
            return userRepository.findStudentsByNameContains(name, groupName, PageRequest.of(page, size, Sort.by(direction, field)))
                    .map(userMapping::toDto);
        }

        //todo clean arcitecture, dto - entity, mapstruct, service
    }

    public void deleteStudent(Long id){
        if (id == null) {
            throw new RuntimeException("Student id is null");
        }
        userRepository.deleteById(id);
    }

    public void changeUser(UserDto user){
        if (user.getId() == null){
            throw new RuntimeException("User id is null");
        }

        User changingUser = userRepository.findById(user.getId()).orElse(null);


        changingUser.setUsername(user.getUsername());
        changingUser.setRole(user.getRole());
        changingUser.setFio(user.getFio());
        changingUser.setPhone_number(user.getPhoneNumber());
        changingUser.setGroups(user.getGroup());
        changingUser.setEnable(user.isEnable());

        userRepository.save(changingUser);
    }

    public UserDto getCurrentUser(Long id) {

        User user = userRepository.findById(id).orElse(null);

        return userMapping.toDto(user);
    }

    public List<GroupDto> getGroups() {

        GroupDto groupDto;
        List<Group> groups = groupRepository.findAll();

        return groups.stream()
                .map(group -> groupMapping.toDto(group))
                .collect(Collectors.toList());

    }


}
