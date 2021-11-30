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
public class Team {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    @OneToMany(mappedBy = "team")
    private List<AppUser> adminAppUsers;

    @OneToMany(mappedBy = "team")
    private List<AppUser> appUsers;
    
    @ManyToOne
    @JoinColumn(name = "organization_id")
    private Organization organization;

}
