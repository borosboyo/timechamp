package hu.bme.aut.timechamp.web.controller.normalcontroller;

import hu.bme.aut.timechamp.dto.EventDto;
import hu.bme.aut.timechamp.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Map;

@Controller
public class EventController {

    @Autowired
    EventService eventService;

    @GetMapping("/events")
    public String home(Map<String, Object> model){
        List<EventDto> events = eventService.findAll();

        model.put("events", events);
        model.put("newEvent", new EventDto());
        return "eventPage";
    }

    @PostMapping("/createEvent")
    public String createEvent(EventDto newEvent){
        eventService.createEvent(newEvent.getName(),newEvent.getTeam().getId(),newEvent.getCreator().getId());
        return "redirect:/events";
    }
}
