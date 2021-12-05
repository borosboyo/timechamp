package hu.bme.aut.timechamp.mapper;

import hu.bme.aut.timechamp.dto.OrganizationDto;
import hu.bme.aut.timechamp.model.Organization;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrganizationMapper {
    public OrganizationDto organizationToDto(Organization organization);
    public List<OrganizationDto> organizationsToDto(List<Organization> organizations);
}
