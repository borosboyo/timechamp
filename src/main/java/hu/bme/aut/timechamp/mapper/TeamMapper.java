package hu.bme.aut.timechamp.mapper;

import hu.bme.aut.timechamp.dto.*;
import hu.bme.aut.timechamp.model.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TeamMapper {
    TeamDto teamToDto(Team team);
    List<TeamDto> teamsToDto(List<Team> teams);

    @Mapping(target = "teams", ignore =  true)
    OrganizationDto organizationToDto(Organization organization);

    @Mapping(target = "organization", ignore =  true)
    PlaceDto placeToDto(Place place);

    @Mapping(target = "team", ignore =  true)
    @Mapping(target = "password", ignore =  true)
    @Mapping(target = "events", ignore =  true)
    @Mapping(target = "todos", ignore =  true)
    AppUserDto appUserToDto(AppUser appUser);

    @Mapping(target = "team", ignore =  true)
    EventDto eventToDto(Event event);
}
