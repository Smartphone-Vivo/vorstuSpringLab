package dev.vorstu.dto;

import dev.vorstu.entity.Group;
import dev.vorstu.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface GroupMapping {

    GroupDto toDto(Group group);

    Group toEntity(GroupDto groupDto);


}