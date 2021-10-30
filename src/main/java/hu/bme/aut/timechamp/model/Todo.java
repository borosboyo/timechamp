package hu.bme.aut.timechamp.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Todo {
    private String name;
    private User leader;
    private Event event;
}
