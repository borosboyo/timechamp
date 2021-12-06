package hu.bme.aut.timechamp.mapper;

import hu.bme.aut.timechamp.dto.OrganizationDto;
import hu.bme.aut.timechamp.dto.PlaceDto;
import hu.bme.aut.timechamp.dto.TeamDto;
import hu.bme.aut.timechamp.model.Organization;
import hu.bme.aut.timechamp.model.Place;
import hu.bme.aut.timechamp.model.Team;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrganizationMapper {
    OrganizationDto organizationToDto(Organization organization);
    List<OrganizationDto> organizationsToDto(List<Organization> organizations);

    @Mapping(target = "organization", ignore =  true)
    PlaceDto placeToDto(Place place);

    @Mapping(target = "organization", ignore =  true)
    TeamDto teamToDto(Team team);
}
