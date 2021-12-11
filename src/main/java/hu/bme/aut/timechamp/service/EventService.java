package hu.bme.aut.timechamp.service;

import hu.bme.aut.timechamp.model.AppUser;
import hu.bme.aut.timechamp.model.Event;
import hu.bme.aut.timechamp.model.Team;
import hu.bme.aut.timechamp.repository.AppUserRepository;
import hu.bme.aut.timechamp.repository.EventRepository;
import hu.bme.aut.timechamp.repository.TeamRepository;
import hu.bme.aut.timechamp.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EventService {

    @Autowired
    EventRepository eventRepository;

    @Autowired
    AppUserRepository appUserRepository;

    @Autowired
    TeamRepository teamRepository;

    @Transactional
    public Event createEvent(String name, long teamId, long creatorId) {
        Team team = teamRepository.getById(teamId);
        AppUser creator = appUserRepository.getById(creatorId);

        Event event = new Event(name, LocalDateTime.now());
        event.setTeam(team);
        event.setCreator(creator);

        Event savedEvent = eventRepository.save(event);
        team.getEvents().add(savedEvent);
        teamRepository.save(team);

        return savedEvent;
    }


    @Transactional
    public Event getById(long id) {
        return eventRepository.getById(id);
    }


    @Transactional
    public Event addParticipant(long id, long userId) {
        Event event = eventRepository.getById(id);
        AppUser user = appUserRepository.getById(userId);
        event.getParticipants().add(user);

        return eventRepository.save(event);
    }
}
