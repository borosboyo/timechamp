package hu.bme.aut.timechamp.web.controller.restcontroller;


import hu.bme.aut.timechamp.dto.EventDto;
import hu.bme.aut.timechamp.mapper.EventMapper;
import hu.bme.aut.timechamp.model.Event;
import hu.bme.aut.timechamp.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventRestController {

    @Autowired
    EventRepository eventRepository;

    @Autowired
    EventMapper eventMapper;

    @GetMapping
    @Transactional
    public List<EventDto> findAll(){
        List<Event> events = eventRepository.findAll();
        return eventMapper.eventsToDto(events);
    }

    @PostMapping
    public Event createEvent(@RequestBody Event event){
        return eventRepository.save(event);
    }
}
