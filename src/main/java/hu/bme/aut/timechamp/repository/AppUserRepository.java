package hu.bme.aut.timechamp.repository;

import hu.bme.aut.timechamp.model.AppUser;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    List<AppUser> findByUserName(String name);

    @EntityGraph(attributePaths = "team.app_users")
    @Query(value = "SELECT a FROM AppUser a")
    List<AppUser> findAllWithTeamAppUsers();

    @EntityGraph(attributePaths = "event.participants")
    @Query(value = "SELECT a FROM AppUser a")
    List<AppUser> findAllWithEventAppUsers();

    @EntityGraph(attributePaths = "todo.leaders")
    @Query(value = "SELECT a FROM AppUser a")
    List<AppUser> findAllWithTodoLeaderAppUsers();

    @Transactional
    AppUser findById(long id);
}
