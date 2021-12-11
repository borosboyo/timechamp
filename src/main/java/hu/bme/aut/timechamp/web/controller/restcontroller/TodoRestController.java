package hu.bme.aut.timechamp.web.controller.restcontroller;

import hu.bme.aut.timechamp.dto.TodoDto;
import hu.bme.aut.timechamp.mapper.TodoMapper;
import hu.bme.aut.timechamp.model.Todo;
import hu.bme.aut.timechamp.repository.TodoRepository;
import hu.bme.aut.timechamp.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class TodoRestController {
    @Autowired
    TodoService todoService;

    @Autowired
    TodoMapper todoMapper;

    @GetMapping
    public List<TodoDto> findAll(){
        return todoService.findAll();
    }


    @PutMapping
    public TodoDto createTodoToEvent(@RequestParam String todoName, @RequestParam long eventId) {
        return todoService.createTodoToEvent(todoName, eventId);
    }

    @GetMapping("/{id}")
    public TodoDto getTodoById(@PathVariable long id) {
        return todoService.getById(id);
    }


    @PostMapping("/{id}/addleader")
    public TodoDto assignLeader(@PathVariable long id, @RequestParam long userId) {
        return todoService.assignLeader(id, userId);
    }

    @PostMapping("/{id}/description")
    public TodoDto setDescription(@PathVariable long id, @RequestParam String description) {
        return todoService.setDescription(id, description);
    }
}
