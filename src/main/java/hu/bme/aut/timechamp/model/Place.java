package hu.bme.aut.timechamp.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
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

    public Place(String name, String googleCode, double longitude, double latitude) {
        this.name = name;
        this.googleCode = googleCode;
        this.longitude = longitude;
        this.latitude = latitude;
    }
}
