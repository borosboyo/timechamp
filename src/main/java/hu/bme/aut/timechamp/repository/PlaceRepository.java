package hu.bme.aut.timechamp.repository;

import hu.bme.aut.timechamp.model.Place;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlaceRepository extends JpaRepository<Place, Long> {
    Place save(Place place);

    List<Place> findByName(String name);

    void delete(Place place);
}
