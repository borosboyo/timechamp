package hu.bme.aut.timechamp.web.controller.restcontroller;


import hu.bme.aut.timechamp.dto.EventDto;
import hu.bme.aut.timechamp.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventRestController {

    @Autowired
    EventService eventService;

    @GetMapping
    public List<EventDto> findAll(){
        return eventService.findAll();
    }


    @PostMapping
    public EventDto createEvent(@RequestParam String name, @RequestParam long team_id, @RequestParam long creator_id) {
        try {
            EventDto eventDto = eventService.createEvent(name, team_id, creator_id);

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
    public EventDto addParticipant(@PathVariable long id, @RequestParam long user_id) {
        try {
            EventDto eventDto = eventService.addParticipant(id, user_id);

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
    public EventDto removeParticipant(@PathVariable long id, @RequestParam long user_id) {
        return eventService.removeParticipant(id, user_id);
    }

    @PostMapping("{id}/time")
    public EventDto setTimeById(@PathVariable long id, @RequestParam int year, @RequestParam int month, @RequestParam int day, @RequestParam int hour, @RequestParam int minute) {
        LocalDateTime time = LocalDateTime.of(year, month, day, hour, minute);
        return eventService.setTimeById(id, time);
    }
}
