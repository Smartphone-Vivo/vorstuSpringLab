package dev.vorstu.dto;

import dev.vorstu.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring")
public interface UserMapping {
    @Mapping(target = "phoneNumber", expression = "java(user.getPhone_number())")
    @Mapping(target = "group", expression = "java(user.getGroups().getGroupName())")
    UserDto toDto(User user);


}
