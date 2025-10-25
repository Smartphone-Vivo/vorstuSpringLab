package dev.vorstu.repositories;

import dev.vorstu.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    @Query("SELECT s FROM User s WHERE " +
            "s.groups.groupName = :groupName AND " +
            "(s.fio LIKE CONCAT('%', :name, '%') OR " +
            "s.phone_number LIKE CONCAT('%', :name, '%'))")
    Page<User> findStudentsByNameContains(@Param("name") String name,
                                          @Param("groupName") String groupName,
                                          Pageable pageable);

    @Query("SELECT s FROM User s WHERE " +
            "(s.fio LIKE CONCAT('%', :name, '%') OR " +
            "s.phone_number LIKE CONCAT('%', :name, '%'))")
    Page<User> findAllStudentsByNameContains(@Param("name") String name,
                                          Pageable pageable);

}
