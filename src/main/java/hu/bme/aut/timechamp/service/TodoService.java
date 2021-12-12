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
        Event event = eventRepository.findById(eventId);

        if(event == null) {
            throw new IllegalArgumentException();
        }

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
    public TodoDto findById(long id) {
        return todoMapper.todoToDto(todoRepository.findById(id));
    }

    @Transactional
    public TodoDto assignLeader(long todoId, long userId) {
        Todo todo = todoRepository.findById(todoId);
        AppUser user = appUserRepository.findById(userId);
        todo.getLeaders().add(user);

        Todo savedTodo = todoRepository.save(todo);
        user.getTodos().add(savedTodo);

        return todoMapper.todoToDto(savedTodo);
    }

    @Transactional
    public TodoDto setDescription(long todoId, String description) {
        Todo todo = todoRepository.findById(todoId);
        todo.setDescription(description);

        return todoMapper.todoToDto(todoRepository.save(todo));
    }
}
