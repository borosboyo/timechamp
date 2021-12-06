package hu.bme.aut.timechamp.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrganizationDto {

    private long id;
    private String name;
    private List<TeamDto> teams;
    private PlaceDto headQuarter;
}
