package hu.bme.aut.timechamp.mapper;

import hu.bme.aut.timechamp.dto.AppUserDto;
import hu.bme.aut.timechamp.dto.EventDto;
import hu.bme.aut.timechamp.dto.OrganizationDto;
import hu.bme.aut.timechamp.dto.TeamDto;
import hu.bme.aut.timechamp.model.AppUser;
import hu.bme.aut.timechamp.model.Event;
import hu.bme.aut.timechamp.model.Organization;
import hu.bme.aut.timechamp.model.Team;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TeamMapper {
    TeamDto teamToDto(Team team);
    List<TeamDto> teamsToDto(List<Team> teams);

    @Mapping(target = "teams", ignore =  true)
    OrganizationDto organizationToDto(Organization organization);

    @Mapping(target = "team", ignore =  true)
    AppUserDto appUserToDto(AppUser appUser);

    @Mapping(target = "team", ignore =  true)
    EventDto eventToDto(Event event);
}
