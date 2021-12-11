package hu.bme.aut.timechamp.service;

import hu.bme.aut.timechamp.dto.EventDto;
import hu.bme.aut.timechamp.mapper.EventMapper;
import hu.bme.aut.timechamp.model.Event;
import hu.bme.aut.timechamp.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PostponeEventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    EventMapper eventMapper;

    @Transactional
    public EventDto postponeByMinute(long id, int timeDifference){
        Event event = eventRepository.findById(id);

        if(event == null) {
            throw new IllegalArgumentException();
        }

        event.setTime(event.getTime().plusMinutes(timeDifference));
        eventRepository.save(event);

        return eventMapper.eventToDto(event);
    }

    @Transactional
    public EventDto postponeByHour(long id, int timeDifference){
        Event event = eventRepository.findById(id);

        if(event == null) {
            throw new IllegalArgumentException();
        }

        event.setTime(event.getTime().plusHours(timeDifference));
        eventRepository.save(event);
        return eventMapper.eventToDto(event);
    }

    @Transactional
    public EventDto postponeByDay(long id, int timeDifference){
        Event event = eventRepository.findById(id);

        if(event == null) {
            throw new IllegalArgumentException();
        }

        event.setTime(event.getTime().plusDays(timeDifference));
        eventRepository.save(event);
        return eventMapper.eventToDto(event);
    }


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