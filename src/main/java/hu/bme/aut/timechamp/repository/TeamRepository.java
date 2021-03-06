package hu.bme.aut.timechamp.repository;

import hu.bme.aut.timechamp.model.Team;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {

    List<Team> findByName(String name);

    @EntityGraph(attributePaths = "organization.teams")
    @Query("SELECT t FROM Team t")
    List<Team> findAllWithOrganizationTeams();

    @EntityGraph(attributePaths = "app_user.team")
    @Query("SELECT t FROM Team t")
    List<Team> findAllWithAppUserTeams();

    @EntityGraph(attributePaths = "event.team")
    @Query("SELECT t FROM Team t")
    List<Team> findAllWithEventTeams();

    Team findById(long id);
}
