package dev.vorstu.controllers;

import dev.vorstu.dto.User;
import dev.vorstu.jwt.JwtAuthentication;
import dev.vorstu.dto.Student;
import dev.vorstu.repositories.StudentRepository;
import dev.vorstu.repositories.UserRepository;
import dev.vorstu.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/base")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class BaseController {

    //todo разделение ролей, разнефе таблички в зависимости от роли(student - видит свою группу, редактирует себя,
    //todo admin - видит и редактирует всех, teacher - видит и редактирует свою группу) На фронте сделать Studentpage,admin,teacher
    //todo чтоб один компонент и в зависимости от роли отображалось

    private final StudentRepository studentRepository;
    private final AuthService authService;
    private final UserRepository userRepository;

    //todo сортировку по группам сделать

    @GetMapping("students/{page}/{size}")
    public Iterable<User> getStudentsWithPagination(
            @PathVariable(name = "page") int page,
            @PathVariable(name = "size") int size,

            @RequestParam(required = false) String name,
            @RequestParam(name = "sort", defaultValue = "id,asc") String sort){

        String[] parts = sort.split(",");
        String field = parts[0];
        Sort.Direction direction = Sort.Direction.fromString(parts[1].toUpperCase());

        if (name == null){
            return userRepository.findAll(PageRequest.of(page, size, Sort.by(sort)));
        }
        else {
            return userRepository.findStudentsByNameContains(name, PageRequest.of(page, size, Sort.by(direction, field)));
        }

        //todo clean arcitecture, dto - entity, mapstruct, service
    }

    //todo удалить
    @GetMapping(value = "students/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Student getStudentById(@PathVariable("id") Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    //todo удалить
    @GetMapping(value = "students/filter", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Student> getStudentByGroup(@RequestParam(value = "group") String group) {
        return studentRepository.findAll().stream()
            .filter(el -> el.getGroup().equals(group)).collect(Collectors.toList());
    }

    //todo админский функционал
    @PostMapping(value = "students", produces = MediaType.APPLICATION_JSON_VALUE)
    public Student createStudent(@RequestBody Student newStudent) {
        return studentRepository.save(newStudent);
    }

    //todo стрим поменять на чето там запрос вроде хз
    @PutMapping(value = "students", produces = MediaType.APPLICATION_JSON_VALUE)
    public User changeStudent(@RequestBody User user) {
        if (user.getId() == null){
            throw new RuntimeException("User id is null");
        }

        User changingUser = userRepository.findAll().stream()
                .filter(el -> Objects.equals(el.getId(), user.getId()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Student not found"));

        changingUser.setUsername(user.getUsername());
        changingUser.setRole(user.getRole());
        changingUser.setFio(user.getFio());
        changingUser.setPhone_number(user.getPhone_number());
        changingUser.setGroups(user.getGroups());
        changingUser.setEnable(user.getEnable());
        return userRepository.save(changingUser);
    }

    @DeleteMapping(value = "students/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteStudent(@PathVariable Long id) {
        if (id == null) {
            throw new RuntimeException("Student id is null");
        }
        studentRepository.deleteById(id);
    }

}
