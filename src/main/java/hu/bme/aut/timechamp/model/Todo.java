package hu.bme.aut.timechamp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Todo {

    @Id
    @GeneratedValue
    private long id;

    @Basic
    private String name;

    @ManyToMany(mappedBy = "todo")
    private ArrayList<User> leaders;

    @ManyToOne
    private Event event;

    @Basic
    private String description;
}
