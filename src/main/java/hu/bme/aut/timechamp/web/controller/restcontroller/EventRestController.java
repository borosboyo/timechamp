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
        return RestUtils.executeRestRequest(() -> eventService.createEvent(name, team_id, creator_id));
    }

    @GetMapping("/{id}")
    public EventDto getEventById(@PathVariable long id) {
        return RestUtils.executeRestRequest(() -> eventService.findById(id), HttpStatus.NOT_FOUND);
    }


    @PostMapping("/{id}/participant/add")
    public EventDto addParticipant(@PathVariable long id, @RequestParam long user_id) {
        return RestUtils.executeRestRequest(() -> eventService.addParticipant(id, user_id));
    }

    @PostMapping("/{id}/participant/remove")
    public EventDto removeParticipant(@PathVariable long id, @RequestParam long user_id) {
        return RestUtils.executeRestRequest(() -> eventService.removeParticipant(id, user_id));
    }

    @PostMapping("{id}/time")
    public EventDto setTimeById(@PathVariable long id, @RequestParam int year, @RequestParam int month, @RequestParam int day, @RequestParam int hour, @RequestParam int minute) {
        LocalDateTime time = LocalDateTime.of(year, month, day, hour, minute);
        return RestUtils.executeRestRequest(() -> eventService.setTimeById(id, time));
    }
}
