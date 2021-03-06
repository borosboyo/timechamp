package hu.bme.aut.timechamp.mapper;

import hu.bme.aut.timechamp.dto.*;
import hu.bme.aut.timechamp.model.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AppUserMapper {
   AppUserDto appUserToDto(AppUser appUser);
   List<AppUserDto> appUsersToDto(List<AppUser> appUsers);

   @Mapping(target = "appUsers", ignore =  true)
   @Mapping(target = "adminAppUsers", ignore =  true)
   TeamDto teamUserToDto(Team team);

   /*@Mapping(target = "adminAppUsers", ignore =  true)
   @Mapping(target = "appUsers", ignore =  true)
   List<TeamDto> teamListToTeamDtoList(List<Team> list);*/

   @Mapping(target = "participants", ignore = true)
   @Mapping(target = "creator", ignore = true)
   @Mapping(target = "todos", ignore = true)
   EventDto eventToEventDto(Event event);

   @Mapping(target = "leaders", ignore =  true)
   @Mapping(target = "event", ignore = true)
   TodoDto todoToDto(Todo todo);

   @Mapping(target = "teams", ignore = true)
   OrganizationDto organizationToDto(Organization organization);

   @Mapping(target = "organization", ignore =  true)
   PlaceDto placeToDto(Place place);
}
