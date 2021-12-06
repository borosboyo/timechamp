package hu.bme.aut.timechamp.repository;

import hu.bme.aut.timechamp.model.Organization;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long> {
    List<Organization> findByName(String name);

    @EntityGraph(attributePaths = "place.organization")
    @Query("SELECT o FROM Organization o")
    List<Organization> findAllWithPlaceOrganization();

    @EntityGraph(attributePaths = "team.organization")
    @Query("SELECT o FROM Organization o")
    List<Organization> findAllWithTeamOrganization();


}
