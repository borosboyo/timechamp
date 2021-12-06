package hu.bme.aut.timechamp.mapper;

import hu.bme.aut.timechamp.dto.OrganizationDto;
import hu.bme.aut.timechamp.dto.TeamDto;
import hu.bme.aut.timechamp.model.Organization;
import hu.bme.aut.timechamp.model.Team;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TeamMapper {
    public TeamDto teamToDto(Team team);
    public List<TeamDto> teamsToDto(List<Team> teams);

    @Mapping(target = "teams", ignore =  true)
    OrganizationDto organizationToDto(Organization organization);
}
