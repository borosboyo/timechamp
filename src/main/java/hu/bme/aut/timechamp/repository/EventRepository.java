package hu.bme.aut.timechamp.repository;

import hu.bme.aut.timechamp.model.Event;
import hu.bme.aut.timechamp.model.Todo;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findByName(String name);

    @EntityGraph(attributePaths = "todo.event")
    @Query("SELECT e FROM Event e")
    List<Todo> findAllWithTodoEvents();

    @EntityGraph(attributePaths = "app_user.events")
    @Query("SELECT e FROM Event e")
    List<Todo> findAllWithAppUserEvents();

    Event findById(long id);
}
