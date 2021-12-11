package hu.bme.aut.timechamp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Event {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    @ManyToOne
    private Team team;

    private LocalDateTime time;

    @ManyToOne
    private AppUser creator;

    @OneToMany
    private List<Todo> todos = new ArrayList<>();

    @ManyToMany(mappedBy = "events")
    private List<AppUser> participants = new ArrayList<>();

    public Event(String name, LocalDateTime time) { this.name = name; this.time = time; }

}

