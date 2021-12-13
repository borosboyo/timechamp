package hu.bme.aut.timechamp.web.controller.restcontroller;

import hu.bme.aut.timechamp.dto.TodoDto;
import hu.bme.aut.timechamp.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
        return RestUtils.executeRestRequest(() -> todoService.createTodoToEvent(name, event_id));
    }

    @GetMapping("/{id}")
    public TodoDto getTodoById(@PathVariable long id) {
        return RestUtils.executeRestRequest(() -> todoService.findById(id), HttpStatus.NOT_FOUND);
    }


    @PostMapping("/{id}/addleader")
    public TodoDto assignLeader(@PathVariable long id, @RequestParam long user_id) {
        return RestUtils.executeRestRequest(() -> todoService.assignLeader(id, user_id));
    }

    @PostMapping("/{id}/removeleader")
    public TodoDto removeLeader(@PathVariable long id, @RequestParam long user_id) {
        return RestUtils.executeRestRequest(() -> todoService.removeLeader(id, user_id));
    }

    @PostMapping("/{id}/description")
    public TodoDto setDescription(@PathVariable long id, @RequestParam String text) {
        return RestUtils.executeRestRequest(() -> todoService.setDescription(id, text));
    }

    @DeleteMapping("/{id}")
    public void DeleteTodoById(@PathVariable long id) {
        RestUtils.executeRestRequest(()->todoService.removeTodo(id));
    }
}
