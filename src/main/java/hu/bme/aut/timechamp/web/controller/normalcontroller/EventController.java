package hu.bme.aut.timechamp.web.controller.normalcontroller;

import hu.bme.aut.timechamp.dto.EventDto;
import hu.bme.aut.timechamp.service.EventService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
        model.put("newEvent", new EventParameters());
        model.put("thUtils", ThUtils.getInstance());
        model.put("addParticipant", new ParticipantParameters());
        model.put("removeParticipant", new ParticipantParameters());
        return "eventPage";
    }

    @PostMapping("/createEvent")
    public String createEvent(EventParameters eventParameters){
        eventService.createEvent(eventParameters.getName(),eventParameters.getTeamId(),eventParameters.getCreatorId());
        return "redirect:/events";
    }

    @RequestMapping(value = "/removeEvent", method = RequestMethod.GET)
    public String removeEvent(@RequestParam(name="eventId") int id){
        eventService.removeEvent(id);
        return "redirect:/events";
    }

    @PostMapping("/addParticipant")
    public String addParticipant(ParticipantParameters participant) {
        eventService.addParticipant(participant.getEventId(), participant.getParticipantId());
        return "redirect:/events";
    }

    @PostMapping("/removeParticipant")
    public String removeParticipant(ParticipantParameters participant) {
        eventService.removeParticipant(participant.getEventId(), participant.getParticipantId());
        return "redirect:/events";
    }


    @Setter
    @Getter
    static
    class EventParameters {
        private String name;
        private long teamId;
        private long creatorId;
    }

    @Setter
    @Getter
    class ParticipantParameters {
        private long eventId;
        private long participantId;
    }
}
