package dev.vorstu.repositories;

import dev.vorstu.dto.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
//    List<Student> id(Long id);
//    Optional<List<Student>> findStudentsByNameStartsWith(String name);


    @Query(value = "select * from StudentsSTP where fio = ?1 limit ?2", nativeQuery = true)
    Optional<List<Student>> findStudentsByNameStartsWith(String name, Long limit);

    //todo use jpql
}
