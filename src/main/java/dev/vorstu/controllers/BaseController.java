package dev.vorstu.controllers;

import dev.vorstu.dto.GroupDto;
import dev.vorstu.dto.UserDto;

import dev.vorstu.services.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("api/base")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class BaseController {


    //todo сделал -

    //todo разделение ролей, разнефе таблички в зависимости от роли(student - видит свою группу, редактирует себя,
    //todo admin - видит и редактирует всех, teacher - видит и редактирует свою группу) На фронте сделать Studentpage,admin,teacher
    //todo чтоб один компонент и в зависимости от роли отображалось

    private final BaseService baseService;

    //todo сортировку по группам сделать

    @GetMapping("group")
    public List<GroupDto> getGroups() {
        return baseService.getGroups();
    }

    @GetMapping("students/{id}/{page}/{size}")
    public Page<UserDto> getStudentsWithPagination(
            @PathVariable(name = "id") Long id,
            @PathVariable(name = "page") int page,
            @PathVariable(name = "size") int size,

            @RequestParam(required = false, defaultValue = "") String name,
            @RequestParam(name = "sort", defaultValue = "id,asc") String sort){

        return baseService.getStudentsWithPagination(id, page, size, name, sort);
    }

    @GetMapping("me/{id}")
    public UserDto getCurrentUser(@PathVariable("id") Long id) {
        return baseService.getCurrentUser(id);
    }

    //todo стрим поменять на чето там запрос вроде хз
    @PutMapping(value = "students", produces = MediaType.APPLICATION_JSON_VALUE)
    public void changeUser(@RequestBody UserDto user) {
        baseService.changeUser(user);
    }

    @DeleteMapping(value = "students/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteStudent(@PathVariable Long id) {
        baseService.deleteStudent(id);
    }

}
