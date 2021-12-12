package hu.bme.aut.timechamp.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TeamDto {

    private long id;
    private String name;
    private List<AppUserDto> adminAppUsers;
    private List<AppUserDto> appUsers;
    private OrganizationDto organization;

}
