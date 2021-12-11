package hu.bme.aut.timechamp.service;

import hu.bme.aut.timechamp.model.AppUser;
import hu.bme.aut.timechamp.model.Event;
import hu.bme.aut.timechamp.model.Todo;
import hu.bme.aut.timechamp.repository.EventRepository;
import hu.bme.aut.timechamp.repository.TeamRepository;
import hu.bme.aut.timechamp.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    @Autowired
    TodoRepository todoRepository;

    @Autowired
    EventRepository eventRepository;


    @Transactional
    public Todo createTodoToEvent(long eventId, String todoName) {
        Event event = eventRepository.getById(eventId);
        Todo todo = new Todo();
        todo.setName(todoName);
        todo.setEvent(event);

        Todo savedTodo = todoRepository.save(todo);
        event.getTodos().add(savedTodo);
        eventRepository.save(event);

        return savedTodo;
    }

    @Transactional
    public void assignLeaders(long todoId, List<AppUser> leaders) {
        Todo todo = todoRepository.getById(todoId);
        todo.setLeaders(leaders);
    }

    @Transactional
    public void setDescription(long todoId, String description) {
        Todo todo = todoRepository.getById(todoId);
        todo.setDescription(description);
    }
}
