package hu.bme.aut.timechamp.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class Todo {
    private String name;
    private ArrayList<User> leaders;
    private Event event;
    private String description;
}
