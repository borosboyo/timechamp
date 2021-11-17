package hu.bme.aut.timechamp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.bytebuddy.asm.Advice;

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

    @Basic
    private String name;

    @ManyToOne
    private Team team;

    @Basic
    private LocalDateTime time;

    @ManyToOne
    private User creator;

    @ManyToMany(mappedBy = "event")
    private ArrayList<User> participants;

    public Event(String name, LocalDateTime time) { this.name = name; this.time = time; }


}
