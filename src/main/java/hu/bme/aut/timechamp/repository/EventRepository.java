package hu.bme.aut.timechamp.repository;

import hu.bme.aut.timechamp.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findByName(String name);
}
