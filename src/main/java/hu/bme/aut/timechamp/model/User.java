package hu.bme.aut.timechamp.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private String email;
    private String userName;
    private String password;
    private Team team;
}
