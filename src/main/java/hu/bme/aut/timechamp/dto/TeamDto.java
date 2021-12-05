package hu.bme.aut.timechamp.dto;

import hu.bme.aut.timechamp.model.AppUser;
import hu.bme.aut.timechamp.model.Organization;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeamDto {

    private long id;

    private String name;

    private List<AppUserDto> adminAppUsers;

    private List<AppUserDto> appUsers;

    private OrganizationDto organization;

}
