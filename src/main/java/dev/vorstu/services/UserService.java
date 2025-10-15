package dev.vorstu.services;

import dev.vorstu.dto.User;
import dev.vorstu.repositories.UserRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
//
//    private final List<User> users;

    private final UserRepository userRepository;

    //todo не факт что достает все что нужно
    public Optional<User> getByLogin(@NonNull String username) {
        return userRepository.findByUsername(username);
//        return users.stream()
//                .filter(user -> login.equals(user.getLogin()))
//                .findFirst();
    }

}
