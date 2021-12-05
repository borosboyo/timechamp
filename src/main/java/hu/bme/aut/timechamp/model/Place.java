package hu.bme.aut.timechamp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Place {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    private String googleCode;

    private double longitude;

    private double latitude;

    @OneToOne
    private Organization organization;
}
