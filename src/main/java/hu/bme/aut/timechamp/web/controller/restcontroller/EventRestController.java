package hu.bme.aut.timechamp.web.controller.restcontroller;


import hu.bme.aut.timechamp.dto.EventDto;
import hu.bme.aut.timechamp.mapper.EventMapper;
import hu.bme.aut.timechamp.model.Event;
import hu.bme.aut.timechamp.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventRestController {

    @Autowired
    EventRepository eventRepository;

    @Autowired
    EventMapper eventMapper;

    @GetMapping
    public List<EventDto> findAll(){
        List<Event> events = eventRepository.findAll();
        return eventMapper.eventsToDto(events);
    }
}
