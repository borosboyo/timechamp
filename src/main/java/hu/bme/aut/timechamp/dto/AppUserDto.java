package hu.bme.aut.timechamp.dto;

import hu.bme.aut.timechamp.model.Event;
import hu.bme.aut.timechamp.model.Todo;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AppUserDto {

    private long id;

    private String email;

    private String userName;

    private String password;

    private List<EventDto> event;

    private List<TodoDto> todo;

    private TeamDto team;

}
