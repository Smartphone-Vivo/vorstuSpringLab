package dev.vorstu.repositories;

import dev.vorstu.dto.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Initializer {

    @Autowired
    private StudentRepository studentRepository;

    public void initial() {
        studentRepository.save(new Student("Igor Gofman1", "BVM-231", "+791"));
        studentRepository.save(new Student("Igor Gofman2", "BVM-231", "+792"));
        studentRepository.save(new Student("Igor Gofman3", "BVM-231", "+793"));
        studentRepository.save(new Student("Igor Gofman4", "BVM-231", "+793"));
        studentRepository.save(new Student("Igor Gofman5", "BVM-231", "+793"));
        studentRepository.save(new Student("Igor Gofman6", "BVM-231", "+793"));
        studentRepository.save(new Student("Igor Gofman7", "BVM-231", "+793"));
    }

    public void getAllStudents(){
        studentRepository.findAll();
    }
}
