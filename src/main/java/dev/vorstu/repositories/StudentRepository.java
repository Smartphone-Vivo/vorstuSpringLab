package dev.vorstu.repositories;

import dev.vorstu.dto.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("SELECT s FROM Student s WHERE " +
            "s.fio LIKE CONCAT('%', :name, '%') OR " +
            "s.group LIKE CONCAT('%', :name, '%') OR " +
            "s.phone_number LIKE CONCAT('%', :name, '%')")
    List<Student> findStudentsByNameContains(@Param("name") String name);



//    @Query(value = "select b from StudentsSTP b where b.fio like :name")
//    List<Student> findByName(@Param("name") String name);

    //todo use jpql
}
