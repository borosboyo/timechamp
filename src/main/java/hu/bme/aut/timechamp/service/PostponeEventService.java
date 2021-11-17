package hu.bme.aut.timechamp.service;

import hu.bme.aut.timechamp.model.Event;
import hu.bme.aut.timechamp.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PostponeEventService {

    @Autowired
    private EventRepository eventRepository;


    @Transactional
    public void postponeByMinute(String eventName, int timeDifference){
        List<Event> eventList = eventRepository.findByName(eventName);
        for (Event event : eventList) {
            event.getTime().plusMinutes(timeDifference);
        }
    }

    @Transactional
    public void postponeByHour(String eventName, int timeDifference){
        List<Event> eventList = eventRepository.findByName(eventName);
        for (Event event : eventList) {
            event.getTime().plusHours(timeDifference);
        }
    }

    @Transactional
    public void postponeByDay(String eventName, int timeDifference){
        List<Event> eventList = eventRepository.findByName(eventName);
        for (Event event : eventList) {
            event.getTime().plusMinutes(timeDifference);
        }
    }

}