package hu.bme.aut.timechamp.repository;

import hu.bme.aut.timechamp.model.AppUser;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    public List<AppUser> findByUserName(String name);

    @EntityGraph(attributePaths = "team.app_users")
    @Query(value = "SELECT a FROM AppUser a")
    public List<AppUser> findAllWithTeamAppUsers();

    @EntityGraph(attributePaths = "event.participants")
    @Query(value = "SELECT a FROM AppUser a")
    public List<AppUser> findAllWithEventAppUsers();

    @EntityGraph(attributePaths = "todo.leaders")
    @Query(value = "SELECT a FROM AppUser a")
    public List<AppUser> findAllWithTodoLeaderAppUsers();

}
