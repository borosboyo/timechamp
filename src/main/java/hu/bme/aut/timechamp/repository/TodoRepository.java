package hu.bme.aut.timechamp.repository;

import hu.bme.aut.timechamp.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Long> {

    List<Todo> findByName(String name);

}
