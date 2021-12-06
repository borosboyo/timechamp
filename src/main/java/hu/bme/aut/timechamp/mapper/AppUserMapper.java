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
public interface AppUserMapper {
   AppUserDto appUserToDto(AppUser appUser);
   List<AppUserDto> appUsersToDto(List<AppUser> appUsers);

   @Mapping(target = "appUsers", ignore =  true)
   TeamDto teamUserToDto(Team team);

   @Mapping(target = "participants", ignore =  true)
   EventDto eventParticipantToDto(Event event);

   @Mapping(target = "leaders", ignore =  true)
   TodoDto todoToDto(Todo todo);
}
