package hu.bme.aut.timechamp.service;

import hu.bme.aut.timechamp.dto.TodoDto;
import hu.bme.aut.timechamp.mapper.TodoMapper;
import hu.bme.aut.timechamp.model.AppUser;
import hu.bme.aut.timechamp.model.Event;
import hu.bme.aut.timechamp.model.Todo;
import hu.bme.aut.timechamp.repository.AppUserRepository;
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

    @Autowired
    AppUserRepository appUserRepository;

    @Autowired
    TodoMapper todoMapper;

    @Transactional
    public List<TodoDto> findAll(){
        return todoMapper.todosToDto(todoRepository.findAll());
    }

    @Transactional
    public TodoDto createTodoToEvent(String todoName, long eventId) {
        Event event = eventRepository.getById(eventId);
        Todo todo = new Todo();
        todo.setName(todoName);
        todo.setEvent(event);

        Todo savedTodo = todoRepository.save(todo);
        event.getTodos().add(savedTodo);

        for(AppUser user : event.getParticipants()) {
            user.getTodos().add(savedTodo);
            appUserRepository.save(user);
        }

        eventRepository.save(event);

        return todoMapper.todoToDto(savedTodo);
    }

    @Transactional
    public TodoDto getById(long id) {
        return todoMapper.todoToDto(todoRepository.getById(id));
    }

    @Transactional
    public TodoDto assignLeader(long todoId, long userId) {
        Todo todo = todoRepository.getById(todoId);
        AppUser user = appUserRepository.getById(userId);
        todo.getLeaders().add(user);

        Todo savedTodo = todoRepository.save(todo);
        user.getTodos().add(savedTodo);

        return todoMapper.todoToDto(savedTodo);
    }

    @Transactional
    public TodoDto setDescription(long todoId, String description) {
        Todo todo = todoRepository.getById(todoId);
        todo.setDescription(description);

        return todoMapper.todoToDto(todoRepository.save(todo));
    }
}
