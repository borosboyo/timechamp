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
    public void postponeByMinute(String name, int timeDifference){
        List<Event> eventList = eventRepository.findByName(name);
        for (Event e : eventList) {
            e.setTime(e.getTime().plusMinutes(timeDifference));
        }
    }

    @Transactional
    public void postponeByHour(String name, int timeDifference){
        List<Event> eventList = eventRepository.findByName(name);
        for (Event e : eventList) {
            e.setTime(e.getTime().plusHours(timeDifference));
        }
    }

    @Transactional
    public void postponeByDay(String name, int timeDifference){
        List<Event> eventList = eventRepository.findByName(name);
        for (Event e : eventList) {
            e.setTime(e.getTime().plusDays(timeDifference));
        }
    }

}