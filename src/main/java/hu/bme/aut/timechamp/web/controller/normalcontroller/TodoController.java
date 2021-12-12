package hu.bme.aut.timechamp.web.controller.normalcontroller;

import hu.bme.aut.timechamp.dto.TodoDto;
import hu.bme.aut.timechamp.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Map;

public class TodoController {

    @Autowired
    TodoService todoService;

    @GetMapping("/todos")
    public String home(Map<String, Object> model){
        List<TodoDto> todos = todoService.findAll();

        model.put("todos", todos);
        model.put("newTodo", new TodoDto());
        return "todoPage";
    }

    @PostMapping("/createTodo")
    public String createTodo(TodoDto newTodo){
        todoService.createTodoToEvent();
        return "redirect:/todos";
    }
}
