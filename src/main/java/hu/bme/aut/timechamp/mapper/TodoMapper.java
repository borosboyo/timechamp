package hu.bme.aut.timechamp.mapper;

import hu.bme.aut.timechamp.dto.*;
import hu.bme.aut.timechamp.model.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TodoMapper {
    TodoDto todoToDto(Todo todo);
    List<TodoDto> todosToDto(List<Todo> todos);

    @Mapping(target = "todos", ignore =  true)
    @Mapping(target = "events", ignore = true)
    @Mapping(target = "team", ignore = true)
    @Mapping(target = "password", ignore = true)
    AppUserDto appUserToDto(AppUser appUser);

    @Mapping(target = "todos", ignore =  true)
    @Mapping(target = "participants", ignore = true)
    EventDto eventToDto(Event event);

    @Mapping(target = "creator", ignore = true)
    @Mapping(target = "appUsers", ignore = true)
    TeamDto teamToDto(Team team);

    @Mapping(target = "teams", ignore =  true)
    OrganizationDto organizationToDto(Organization organization);

    @Mapping(target = "organization", ignore =  true)
    PlaceDto placeToDto(Place place);
}
