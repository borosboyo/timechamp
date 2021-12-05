package hu.bme.aut.timechamp.dto;

import hu.bme.aut.timechamp.model.Organization;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlaceDto {

    private long id;
    private String name;
    private String googleCode;
    private double longitude;
    private double latitude;

    private OrganizationDto organization;

}
