package hu.bme.aut.timechamp.repository;

import hu.bme.aut.timechamp.model.Event;

import java.util.List;

public interface EventRepository {
    Event save(Event event);

    List<Event> findByName(String name);

    void delete(Event event);
}
