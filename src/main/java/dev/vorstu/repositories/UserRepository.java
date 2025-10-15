package dev.vorstu.repositories;

import dev.vorstu.dto.Student;
import dev.vorstu.dto.User1;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User1, Long> {

    Optional<User1> findByUsername(String username);

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
