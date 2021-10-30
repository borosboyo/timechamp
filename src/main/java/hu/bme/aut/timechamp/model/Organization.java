package hu.bme.aut.timechamp.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class Organization {
    private String name;
    private ArrayList<Team> teams;
    private Place headQuarters;
}
