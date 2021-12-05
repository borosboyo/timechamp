package hu.bme.aut.timechamp.dto;

import hu.bme.aut.timechamp.model.Event;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@Getter
@Setter
public class TodoDto {

    private long id;

    private String name;

    private List<AppUserDto> leaders;

    private EventDto event;

    private String description;
}
