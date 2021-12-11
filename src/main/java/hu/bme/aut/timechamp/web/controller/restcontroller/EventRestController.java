package hu.bme.aut.timechamp.web.controller.restcontroller;


import hu.bme.aut.timechamp.dto.EventDto;
import hu.bme.aut.timechamp.mapper.EventMapper;
import hu.bme.aut.timechamp.model.Event;
import hu.bme.aut.timechamp.repository.EventRepository;
import hu.bme.aut.timechamp.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/events")
public class EventRestController {

    @Autowired
    EventService eventService;

    @GetMapping
    public List<EventDto> findAll(){
        return eventService.findAll();
    }


    @PutMapping
    public EventDto createEvent(@RequestParam String name, @RequestParam long teamId, @RequestParam long creatorId) {
        try {
            EventDto eventDto = eventService.createEvent(name, teamId, creatorId);

            if(eventDto == null) {
                throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
            }

            return eventDto;
        }
        catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad parameters");
        }
    }


    @GetMapping("/{id}")
    public EventDto getEventById(@PathVariable long id) {
        EventDto eventDto = eventService.findById(id);
        if(eventDto == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        return eventDto;
    }


    @PostMapping("/{id}/participant/add")
    public EventDto addParticipant(@PathVariable long id, @RequestParam long appUserId) {
        try {
            EventDto eventDto = eventService.addParticipant(id, appUserId);

            if(eventDto == null) {
                throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
            }

            return eventDto;
        }
        catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad parameters");
        }
    }

    @PostMapping("/{id}/participant/remove")
    public EventDto removeParticipant(@PathVariable long id, @RequestParam long appUserId) {
        return eventService.removeParticipant(id, appUserId);
    }

    @PostMapping("{id}/time")
    public EventDto setTimeById(@PathVariable long id, @RequestParam int year, @RequestParam int month, @RequestParam int day, @RequestParam int hour, @RequestParam int minute) {
        LocalDateTime time = LocalDateTime.of(year, month, day, hour, minute);
        return eventService.setTimeById(id, time);
    }
}
