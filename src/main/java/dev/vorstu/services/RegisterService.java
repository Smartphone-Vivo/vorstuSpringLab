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
                new Password(user.getPassword()),
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