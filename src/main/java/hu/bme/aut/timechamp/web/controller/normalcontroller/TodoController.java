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
        model.put("newDesc", new TodoParameters());
        model.put("newLeader", new TodoUserParameters());
        model.put("removeLeader", new TodoUserParameters());
        model.put("thUtils", ThUtils.getInstance());
        return "todoPage";
    }

    @PostMapping("/createTodo")
    public String createTodo(TodoParameters todoParameters){
        todoService.createTodoToEvent(todoParameters.getName(),todoParameters.getEventId());
        return "redirect:/todos";
    }

    @PostMapping("/setTodoDescription")
    public String setTodoDescription(TodoParameters todoParameters){
        todoService.setDescription(todoParameters.getId(), todoParameters.getDescription());
        return "redirect:/todos";
    }

    @RequestMapping(value = "/removeTodo", method = RequestMethod.GET)
    public String removeEvent(@RequestParam(name="todoId") int id){
        todoService.removeTodo(id);
        return "redirect:/todos";
    }

    @PostMapping("/assignTodoLeader")
    public String assignTodoLeader(TodoUserParameters todoUserParameters){
        todoService.assignLeader(todoUserParameters.getTodoId(), todoUserParameters.getUserId());
        return "redirect:/todos";
    }

    @PostMapping("/removeTodoLeader")
    public String removeTodoLeader(TodoUserParameters todoUserParameters){
        todoService.removeLeader(todoUserParameters.getTodoId(), todoUserParameters.getUserId());
        return "redirect:/todos";
    }

    @Setter
    @Getter
    static
    class TodoParameters {
        private long id;
        private String name;
        private long eventId;
        private String description;
    }

    @Setter
    @Getter
    static
    class TodoUserParameters {
        private long todoId;
        private long userId;
    }
}
