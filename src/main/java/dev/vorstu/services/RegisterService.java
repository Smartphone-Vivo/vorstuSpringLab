package dev.vorstu.services;

import dev.vorstu.dto.*;
import dev.vorstu.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterService {

    private final UserRepository userRepository;

    public void register(JwtRequest user){
        User student = new User(
                null,
                user.getUsername(),
                Role.STUDENT,
                "igor",
                "1488",
                new Password(user.getPassword()),
                new Group(), //todo group
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