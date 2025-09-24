package dev.vorstu.controllers;

import dev.vorstu.dto.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("api/base")
public class BaseController {

    private Long counter = 0L;

    private Long generateId(){
        return counter++;
    }

    private final List<Student> students = new ArrayList<>();

    @PostConstruct
    private void init() {
        students.add(new Student(0L, "Igor Gofman1","bIVT-231","1234567"));
        students.add(new Student(1L,"Igor Gofman2","bIVT-231","1234567"));
        students.add(new Student(2L,"Igor Gofman3","bIVT-231","1234567"));
    }

    @GetMapping("students")
    public List<Student> getAllStudents() {
        return students;
    }

    @GetMapping(value = "students/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Student getStudentById(@PathVariable("id") Long id) {
        return students.stream()
                .filter(el -> el.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Student with id " + id + "was not found"));
    }

    @GetMapping(value = "students/filter", produces = MediaType.APPLICATION_JSON_VALUE)
    public Student getStudentByGroup(@RequestParam(value = "group") String group) {
        return students.stream()
                .filter(el -> el.getGroup().equals(group))
                .findFirst()
                .orElse(null);
    }

    @PostMapping(value = "students", produces = MediaType.APPLICATION_JSON_VALUE)
    public Student createStudent(@RequestBody Student newStudent) {
        return addStudent(newStudent);
    }

    private Student addStudent(Student student){
        student.setId(generateId());
        students.add(student);
        return student;
    };

    @PutMapping(value = "students", produces = MediaType.APPLICATION_JSON_VALUE)
    public Student changeStudent(@RequestBody Student changingStudent) {
        return updateStudent(changingStudent);
    }

    private Student updateStudent(Student student){
        if (student.getId() == null){
            throw new RuntimeException("Student id is null");
        }

        Student changingStudent = students.stream()
                .filter(el -> Objects.equals(el.getId(), student.getId()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Student not found"));

        changingStudent.setFio(student.getFio());
        changingStudent.setGroup(student.getGroup());
        changingStudent.setPhoneNumber(student.getPhoneNumber());
        return student;

    }

    @DeleteMapping(value = "students/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public long deleteStudent(@PathVariable Long id) {
        if (id == null) {
            throw new RuntimeException("Student id is null");
        }
        return removeStudent(id);
    }

    private Long removeStudent(Long id) {
        students.removeIf(el -> el.getId().equals(id));
        return id;
    }


    @GetMapping("check")
    public String greetJava(){
        return "Hello World" + new Date();
    }
}
