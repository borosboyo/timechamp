package hu.bme.aut.timechamp.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Event {
    private String name;
    private User creator;
}
