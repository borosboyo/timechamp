package hu.bme.aut.timechamp.repository;

import hu.bme.aut.timechamp.model.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Long> {

    List<Place> findByName(String name);

}
