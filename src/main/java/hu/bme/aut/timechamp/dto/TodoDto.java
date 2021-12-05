package hu.bme.aut.timechamp.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TodoDto {

    private long id;
    private String name;
    private String description;
    private List<AppUserDto> leaders;
    private EventDto event;

}
