package hu.bme.aut.timechamp.model;

import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;

@Getter
@Setter
public class Team {
    private String name;
    private ArrayList<User> adminUsers;
    private ArrayList<User> users;
}
