package hu.bme.aut.timechamp.repository;

import hu.bme.aut.timechamp.model.Todo;
import java.util.List;

public interface TodoRepository {
    Todo save(Todo todo);

    List<Todo> findByName(String name);

    void delete(Todo todo);
}
