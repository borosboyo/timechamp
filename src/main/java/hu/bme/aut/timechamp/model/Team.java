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
public class Team {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    @ManyToMany()
    @JoinTable(name = "team_adminappusers",
            joinColumns = @JoinColumn(name = "team_id"))
    private List<AppUser> adminAppUsers = new ArrayList<>();

    @OneToMany(mappedBy = "team")
    private List<AppUser> appUsers = new ArrayList<>();
    
    @ManyToOne
    @JoinColumn(name = "organization_id")
    private Organization organization;

    @OneToMany(mappedBy = "team")
    private List<Event> events = new ArrayList<>();

}
