package hu.bme.aut.timechamp.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Getter
@Setter
public class Event {
    private String name;
    private Team team;
    private LocalDateTime time;
    private ArrayList<User> creators;
    private ArrayList<User> participants;
    private ArrayList<Todo> todoList;
}
