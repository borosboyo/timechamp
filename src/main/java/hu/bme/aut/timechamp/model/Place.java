package hu.bme.aut.timechamp.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Place {
    private String name;
    private String googleCode;
    private double longitude;
    private double latitude;
}
