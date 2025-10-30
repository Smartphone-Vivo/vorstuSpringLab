package dev.vorstu.controllers;

import dev.vorstu.dto.UserDto;
import dev.vorstu.entity.Group;
import dev.vorstu.entity.User;
import dev.vorstu.entity.Student;
import dev.vorstu.enums.Role;
import dev.vorstu.repositories.GroupRepository;
import dev.vorstu.repositories.StudentRepository;
import dev.vorstu.repositories.UserRepository;
import dev.vorstu.services.AuthService;
import dev.vorstu.services.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/base")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class BaseController {


    //todo сделал -

    //todo разделение ролей, разнефе таблички в зависимости от роли(student - видит свою группу, редактирует себя,
    //todo admin - видит и редактирует всех, teacher - видит и редактирует свою группу) На фронте сделать Studentpage,admin,teacher
    //todo чтоб один компонент и в зависимости от роли отображалось

    private final StudentRepository studentRepository;
    private final AuthService authService;
    private final UserRepository userRepository;
    private final GroupRepository groupRepository;
    private final BaseService baseService;

    //todo сортировку по группам сделать

    @GetMapping("group")
    public List<Group> getGroups() {
        return groupRepository.findAll();
    }

    @GetMapping("students/{id}/{page}/{size}")
    public Iterable<UserDto> getStudentsWithPagination(
            @PathVariable(name = "id") Long id,
            @PathVariable(name = "page") int page,
            @PathVariable(name = "size") int size,

            @RequestParam(required = false, defaultValue = "") String name,
            @RequestParam(name = "sort", defaultValue = "id,asc") String sort){

        return baseService.getStudentsWithPagination(id, page, size, name, sort);
    }

    @GetMapping("me/{id}")
    public User getCurrentUser(@PathVariable("id") Long id) {
        return userRepository.findById(id).orElse(null);
    }

    //todo стрим поменять на чето там запрос вроде хз
    @PutMapping(value = "students", produces = MediaType.APPLICATION_JSON_VALUE)
    public User changeUser(@RequestBody User user) {
        return baseService.changeUser(user);
    }

    @DeleteMapping(value = "students/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteStudent(@PathVariable Long id) {
        baseService.deleteStudent(id);
    }

}
