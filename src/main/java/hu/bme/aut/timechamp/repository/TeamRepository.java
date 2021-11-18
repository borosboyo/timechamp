package hu.bme.aut.timechamp.repository;

import hu.bme.aut.timechamp.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeamRepository extends JpaRepository<Team, Long> {

    List<Team> findByName(String name);

}
