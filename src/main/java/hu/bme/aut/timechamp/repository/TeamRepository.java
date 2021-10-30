package hu.bme.aut.timechamp.repository;

import hu.bme.aut.timechamp.model.Team;
import java.util.List;

public interface TeamRepository {
    Team save(Team team);

    List<Team> findByName(String name);

    void delete(Team team);
}
