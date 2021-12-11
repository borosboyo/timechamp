package hu.bme.aut.timechamp.web.controller.restcontroller;

import hu.bme.aut.timechamp.dto.EventDto;
import hu.bme.aut.timechamp.service.PostponeEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostPoneEventRestService {

    @Autowired
    PostponeEventService postponeEventService;

    @PostMapping("/api/events/{id}/postponeByMinute")
    public EventDto postponeByMinute(@PathVariable long id, @RequestParam int difference){
        return postponeEventService.postponeByMinute(id,difference);
    }

    @PostMapping("/api/events/{id}/postponeByHour")
    public EventDto postponeByHour(@PathVariable long id, @RequestParam int difference){
        return postponeEventService.postponeByMinute(id,difference);
    }

    @PostMapping("/api/events/{id}/postponeByDay")
    public EventDto postponeByDay(@PathVariable long id, @RequestParam int difference){
        return postponeEventService.postponeByMinute(id,difference);
    }

}
