package hu.bme.aut.timechamp.repository;

import hu.bme.aut.timechamp.model.Place;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Long> {

    List<Place> findByName(String name);

    Place findById(long id);

    @EntityGraph(attributePaths = "organization.head_quarter")
    @Query("SELECT p FROM Place p")
    List<Place> findAllWithOrganizationPlaces();
}
