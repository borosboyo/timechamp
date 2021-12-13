package hu.bme.aut.timechamp.web.controller.normalcontroller;

import hu.bme.aut.timechamp.dto.TodoDto;
import hu.bme.aut.timechamp.service.TodoService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class TodoController {

    @Autowired
    TodoService todoService;

    @GetMapping("/todos")
    public String home(Map<String, Object> model){
        List<TodoDto> todos = todoService.findAll();

        model.put("todos", todos);
        model.put("newTodo", new TodoParameters());
        return "todoPage";
    }

    @PostMapping("/createTodo")
    public String createTodo(TodoParameters todoParameters){
        todoService.createTodoToEvent(todoParameters.getName(),todoParameters.getEventId());
        return "redirect:/todos";
    }

    @RequestMapping(value = "/removeTodo", method = RequestMethod.GET)
    public String removeEvent(@RequestParam(name="todoId") int id){
        todoService.removeTodo(id);
        return "redirect:/todos";
    }

    @Setter
    @Getter
    static
    class TodoParameters {
        private String name;
        private long eventId;
    }
}
