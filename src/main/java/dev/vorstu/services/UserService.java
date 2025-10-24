package dev.vorstu.services;

import dev.vorstu.entity.User;
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

    public Optional<User> getByLogin(@NonNull String username) {
        return userRepository.findByUsername(username);
//        return users.stream()
//                .filter(user -> login.equals(user.getLogin()))
//                .findFirst();
    }

}
