package dev.vorstu.services;

import dev.vorstu.entity.User;
import dev.vorstu.enums.Role;
import dev.vorstu.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Service
@RequiredArgsConstructor
public class BaseService {

    private final UserRepository userRepository;

    public void deleteStudent(Long id){
        if (id == null) {
            throw new RuntimeException("Student id is null");
        }
        userRepository.deleteById(id);
    }

    public User changeUser(User user){
        if (user.getId() == null){
            throw new RuntimeException("User id is null");
        }

        User changingUser = userRepository.findById(user.getId()).orElse(null);

        changingUser.setUsername(user.getUsername());
        changingUser.setRole(user.getRole());
        changingUser.setFio(user.getFio());
        changingUser.setPhone_number(user.getPhone_number());
        changingUser.setGroups(user.getGroups());
        changingUser.setEnable(user.getEnable());

        return userRepository.save(changingUser);
    }

    public Iterable<User> getStudentsWithPagination(Long id, int page, int size, String name, String sort){
        User user = userRepository.findById(id).orElse(null);

        String groupName = user.getGroups().getGroupName();

        String[] parts = sort.split(",");
        String field = parts[0];
        Sort.Direction direction = Sort.Direction.fromString(parts[1].toUpperCase());
        if (field.equals("group")) {
            field = "groups.groupName";
        }

        if(user.getRole() == Role.ADMIN){
            return userRepository.findAllStudentsByNameContains(name, PageRequest.of(page, size, Sort.by(direction, field)));
        }
        else{
            return userRepository.findStudentsByNameContains(name, groupName, PageRequest.of(page, size, Sort.by(direction, field)));
        }

        //todo clean arcitecture, dto - entity, mapstruct, service
    }
}
