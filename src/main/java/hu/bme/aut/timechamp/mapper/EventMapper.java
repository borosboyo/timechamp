package hu.bme.aut.timechamp.mapper;

import hu.bme.aut.timechamp.dto.*;
import hu.bme.aut.timechamp.model.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EventMapper {
    EventDto eventToDto(Event event);

    @Mapping(target = "participants", ignore = true)
    List<EventDto> eventsToDto(List<Event> events);

    @Mapping(target = "event", ignore =  true)
    @Mapping(target = "leaders", ignore =  true)
    TodoDto todoToDto(Todo todo);

    @Mapping(target = "events", ignore =  true)
    @Mapping(target = "todos", ignore =  true)
    @Mapping(target = "team", ignore = true)
    @Mapping(target = "password", ignore = true)
    AppUserDto appUserToDto(AppUser appUser);

    @Mapping(target = "appUsers", ignore =  true)
    @Mapping(target = "adminAppUsers", ignore =  true)
    TeamDto teamUserToDto(Team team);

    @Mapping(target = "adminAppUsers", ignore =  true)
    @Mapping(target = "appUsers", ignore =  true)
    List<TeamDto> teamListToTeamDtoList(List<Team> list);

    @Mapping(target = "teams", ignore = true)
    OrganizationDto organizationToDto(Organization organization);
}

