package dev.vorstu.services;

import dev.vorstu.dto.*;
import dev.vorstu.entity.Group;
import dev.vorstu.entity.Password;
import dev.vorstu.entity.User;
import dev.vorstu.enums.Role;
import dev.vorstu.repositories.GroupRepository;
import dev.vorstu.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterService {

    private final UserRepository userRepository;
    private final GroupRepository groupRepository;

    public void register(RegisterRequest user){
        Group group = groupRepository.findById(user.getGroupId()).orElse(null);
        User student = new User(
                null,
                user.getUsername(),
                Role.STUDENT,
                user.getFio(),
                user.getPassword(),
                new Password(user.getPassword()),
                group,
                //todo group
                true
        );
        userRepository.save(student);
    }

}
//User student = new User(
//        null,
//        "student",
//        Role.USER,
//        new Password("1234"),
//        true
//);