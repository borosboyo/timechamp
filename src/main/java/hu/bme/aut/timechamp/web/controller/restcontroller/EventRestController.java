package hu.bme.aut.timechamp.web.controller.restcontroller;


import hu.bme.aut.timechamp.dto.EventDto;
import hu.bme.aut.timechamp.mapper.EventMapper;
import hu.bme.aut.timechamp.model.Event;
import hu.bme.aut.timechamp.repository.EventRepository;
import hu.bme.aut.timechamp.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/events")
public class EventRestController {

    @Autowired
    EventService eventService;

    @Autowired
    EventMapper eventMapper;

    @GetMapping
    public List<EventDto> findAll(){
        return eventMapper.eventsToDto(eventService.findAll());
    }


    @PutMapping
    public EventDto createEvent(@RequestParam String name, @RequestParam long teamId, @RequestParam long creatorId) {
        return eventMapper.eventToDto(eventService.createEvent(name, teamId, creatorId));
    }


    @GetMapping("{id}")
    public EventDto getEventById(@PathVariable long id) {
        return eventMapper.eventToDto(eventService.getById(id));
    }


    @PostMapping
    public EventDto addParticipant(@RequestParam long id, @RequestParam long appUserId) {
        return eventMapper.eventToDto(eventService.addParticipant(id, appUserId));
    }
}
