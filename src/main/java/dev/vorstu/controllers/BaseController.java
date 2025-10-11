package dev.vorstu.controllers;

import dev.vorstu.dto.Student;
import dev.vorstu.repositories.StudentRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@RequestMapping("api/base")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class BaseController {

    private final StudentRepository studentRepository;

    @GetMapping("students")
    public Iterable<Student> getStudentsWithPagination(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "5") int size,
            @RequestParam(required = false) String name){

        //todo sort as parameter
        //todo add filter by name
        if (name == null){
            return studentRepository.findAll(PageRequest.of(page, size, Sort.by("id")));
        }
        else {
            return studentRepository.findStudentsByNameContains(name, PageRequest.of(page, size, Sort.by("id")));
        }

    }

//    @GetMapping( "/search")
//    public List<Student> findByName(@RequestParam(required = false) String name) {
//
//        return studentRepository.findStudentsByNameContains(name);
//    }

    @GetMapping(value = "students/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Student getStudentById(@PathVariable("id") Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @GetMapping(value = "students/filter", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Student> getStudentByGroup(@RequestParam(value = "group") String group) {
        return studentRepository.findAll().stream()
            .filter(el -> el.getGroup().equals(group)).collect(Collectors.toList());


    }


    @PostMapping(value = "students", produces = MediaType.APPLICATION_JSON_VALUE)
    public Student createStudent(@RequestBody Student newStudent) {
        return studentRepository.save(newStudent);
    }

    @PutMapping(value = "students", produces = MediaType.APPLICATION_JSON_VALUE)
    public Student changeStudent(@RequestBody Student student) {
        if (student.getId() == null){
            throw new RuntimeException("Student id is null");
        }


        Student changingStudent = studentRepository.findAll().stream()
                .filter(el -> Objects.equals(el.getId(), student.getId()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Student not found"));

        changingStudent.setFio(student.getFio());
        changingStudent.setGroup(student.getGroup());
        changingStudent.setPhone_number(student.getPhone_number());
        return studentRepository.save(changingStudent);
    }

    @DeleteMapping(value = "students/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteStudent(@PathVariable Long id) {
        if (id == null) {
            throw new RuntimeException("Student id is null");
        }
        studentRepository.deleteById(id);
    }

}
