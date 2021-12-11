package hu.bme.aut.timechamp.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AppUserDto {

    private long id;
    private String email;
    private String username;
    private String password;
   /* private List<EventDto> events;
    private List<TodoDto> todos;
    private TeamDto team;*/

}
