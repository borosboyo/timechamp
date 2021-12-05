package hu.bme.aut.timechamp.mapper;

import hu.bme.aut.timechamp.dto.EventDto;
import hu.bme.aut.timechamp.model.Event;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EventMapper {
    public EventDto eventToDto(Event event);
    public List<EventDto> eventsToDto(List<Event> events);
}
