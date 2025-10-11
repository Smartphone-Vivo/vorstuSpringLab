package dev.vorstu.repositories;

import dev.vorstu.entity.Student;
import dev.vorstu.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends JpaRepository<User, Long> {



}
