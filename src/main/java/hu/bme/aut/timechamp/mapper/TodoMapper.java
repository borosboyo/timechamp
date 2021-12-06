package hu.bme.aut.timechamp.mapper;

import hu.bme.aut.timechamp.dto.TodoDto;
import hu.bme.aut.timechamp.model.Todo;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TodoMapper {
    public TodoDto todoToDto(Todo todo);
    public List<TodoDto> todosToDto(List<Todo> todos);
}
