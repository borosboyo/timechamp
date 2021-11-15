package hu.bme.aut.timechamp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Place {

    @Id
    @GeneratedValue
    private long id;

    @Basic
    private String name;

    @Basic
    private String googleCode;

    @Basic
    private double longitude;

    @Basic
    private double latitude;
}
