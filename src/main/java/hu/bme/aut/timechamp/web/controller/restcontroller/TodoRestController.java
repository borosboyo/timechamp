package hu.bme.aut.timechamp.web.controller.restcontroller;

import hu.bme.aut.timechamp.dto.TodoDto;
import hu.bme.aut.timechamp.mapper.TodoMapper;
import hu.bme.aut.timechamp.model.Todo;
import hu.bme.aut.timechamp.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class TodoRestController {

    @Autowired
    TodoRepository todoRepository;

    @Autowired
    TodoMapper todoMapper;

    @GetMapping
    public List<TodoDto> findAll(){
        List<Todo> todos = todoRepository.findAll();
        return todoMapper.todosToDto(todos);
    }
}
