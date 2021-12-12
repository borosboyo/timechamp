package hu.bme.aut.timechamp.web.controller.restcontroller;

import hu.bme.aut.timechamp.dto.TodoDto;
import hu.bme.aut.timechamp.mapper.TodoMapper;
import hu.bme.aut.timechamp.model.Todo;
import hu.bme.aut.timechamp.repository.TodoRepository;
import hu.bme.aut.timechamp.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class TodoRestController {
    @Autowired
    TodoService todoService;

    @GetMapping
    public List<TodoDto> findAll(){
        return todoService.findAll();
    }


    @PostMapping
    public TodoDto createTodoToEvent(@RequestParam String name, @RequestParam long event_id) {
        try {
            return todoService.createTodoToEvent(name, event_id);
        }
        catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public TodoDto getTodoById(@PathVariable long id) {
        TodoDto todoDto = todoService.findById(id);
        if(todoDto == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        return todoDto;
    }


    @PostMapping("/{id}/addleader")
    public TodoDto assignLeader(@PathVariable long id, @RequestParam long user_id) {
        return todoService.assignLeader(id, user_id);
    }

    @PostMapping("/{id}/description")
    public TodoDto setDescription(@PathVariable long id, @RequestParam String description) {
        return todoService.setDescription(id, description);
    }
}
