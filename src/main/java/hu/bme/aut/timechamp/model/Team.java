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
public class Team {

    @Id
    @GeneratedValue
    private long id;

    @Basic
    private String name;

    @OneToMany(mappedBy = "team")
    private ArrayList<User> adminUsers;

    @OneToMany(mappedBy = "team")
    private ArrayList<User> users;
    
    @ManyToOne
    @JoinColumn(name = "organization_id")
    private Organization organization;

}
