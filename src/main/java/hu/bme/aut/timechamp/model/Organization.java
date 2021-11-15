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
public class Organization {

    @Id
    @GeneratedValue
    private long id;

    @Basic
    private String name;

    @OneToMany(mappedBy = "organization")
    private ArrayList<Team> teams;

    @OneToOne
    private Place headQuarters;
}
