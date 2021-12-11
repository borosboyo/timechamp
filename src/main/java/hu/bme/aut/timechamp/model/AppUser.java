package hu.bme.aut.timechamp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class AppUser {

    @Id
    @GeneratedValue
    private long id;

    private String email;

    private String username;

    private String password;

    @ManyToMany
    @JoinTable(name = "appuser_events",
            joinColumns = @JoinColumn(name = "appuser_id"))
    private List<Event> events = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "appuser_todos",
            joinColumns = @JoinColumn(name = "appuser_id"))
    private List<Todo> todos = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;


    public AppUser(String email, String username, String password) {
        this.email = email;
        this.username = username;
        this.password = password;
    }
}
