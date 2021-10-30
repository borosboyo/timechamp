package hu.bme.aut.timechamp.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class Event {
    private String name;
    private User creator;
    private ArrayList<User> participants;
    private ArrayList<Todo> todoList;
}
