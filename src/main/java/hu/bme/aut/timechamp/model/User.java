package hu.bme.aut.timechamp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue
    private long id;

    private String email;

    private String userName;

    private String password;

    @ManyToMany
    @JoinTable(name = "user_event",
            joinColumns = @JoinColumn(name = "user_id"))
    private List<Event> event;

    @ManyToMany
    @JoinTable(name = "user_todo",
            joinColumns = @JoinColumn(name = "user_id"))
    private List<Todo> todo;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

}
