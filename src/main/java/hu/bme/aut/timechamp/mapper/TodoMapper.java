package hu.bme.aut.timechamp.mapper;

import hu.bme.aut.timechamp.dto.AppUserDto;
import hu.bme.aut.timechamp.dto.EventDto;
import hu.bme.aut.timechamp.dto.TeamDto;
import hu.bme.aut.timechamp.dto.TodoDto;
import hu.bme.aut.timechamp.model.AppUser;
import hu.bme.aut.timechamp.model.Event;
import hu.bme.aut.timechamp.model.Team;
import hu.bme.aut.timechamp.model.Todo;
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
    AppUserDto appUserToDto(AppUser appUser);

    @Mapping(target = "todos", ignore =  true)
    @Mapping(target = "team", ignore = true)
    EventDto eventToDto(Event event);
}
