package hu.bme.aut.timechamp.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class EventDto{

    private long id;
    private String name;
    private TeamDto team;
    private LocalDateTime time;
    private AppUserDto creator;
    private List<AppUserDto> participants;

    public EventDto(String name, LocalDateTime time) { this.name = name; this.time = time; }
}
