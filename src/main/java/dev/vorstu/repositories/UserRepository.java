package dev.vorstu.repositories;

import dev.vorstu.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

//    @Query("SELECT s FROM User1 s WHERE " +
//            "s.username LIKE(:username)")
//    public Optional<User1> findByUsername(String username);


//    @Query("SELECT s FROM Student s WHERE " +
//            "s.fio LIKE CONCAT('%', :name, '%') OR " +
//            "s.group LIKE CONCAT('%', :name, '%') OR " +
//            "s.phone_number LIKE CONCAT('%', :name, '%')")
//    Page<Student> findStudentsByNameContains(@Param("name") String name,
//                                             Pageable pageable);
}
