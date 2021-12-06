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
public class Organization {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    @OneToMany(mappedBy = "organization")
    private List<Team> teams;

    @OneToOne
    private Place headQuarter;
}
