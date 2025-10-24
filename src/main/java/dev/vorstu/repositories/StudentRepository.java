package dev.vorstu.repositories;


import dev.vorstu.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("SELECT s FROM Student s WHERE " +
            "s.fio LIKE CONCAT('%', :name, '%') OR " +
            "s.group LIKE CONCAT('%', :name, '%') OR " +
            "s.phone_number LIKE CONCAT('%', :name, '%')")
    Page<Student> findStudentsByNameContains(@Param("name") String name,
                                             Pageable pageable);

}
