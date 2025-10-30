package dev.vorstu.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String username;
    private String role;
    private String fio;
    private String phoneNumber;
    private String group;
    private boolean enable;


}
