package hu.bme.aut.timechamp.repository;

import hu.bme.aut.timechamp.model.Todo;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {

    List<Todo> findByName(String name);

    @EntityGraph(attributePaths = "app_user.todos")
    @Query("SELECT t FROM Todo t")
    List<Todo> findAllWithAppUserTodos();

    @EntityGraph(attributePaths = "event.todos")
    @Query("SELECT t FROM Todo t")
    List<Todo> findAllWithEventTodos();

    Todo findById(long id);

    @Modifying
    @Transactional
    int removeById(long id);
}
