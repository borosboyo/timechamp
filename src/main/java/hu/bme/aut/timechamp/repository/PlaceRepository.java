package hu.bme.aut.timechamp.repository;

import hu.bme.aut.timechamp.model.Place;
import java.util.List;

public interface PlaceRepository {
    Place save(Place place);

    List<Place> findByName(String name);

    void delete(Place place);
}
