package dev.vorstu.dto;

import dev.vorstu.entity.Group;

import dev.vorstu.enums.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequest {
    private Long id;
    private String username;
    private Role role;
    private String fio;
    private String phoneNumber;
    private String password;
    private int groupId;
    private boolean enable;

}
