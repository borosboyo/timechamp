package hu.bme.aut.timechamp.service;

import hu.bme.aut.timechamp.dto.EventDto;
import hu.bme.aut.timechamp.mapper.EventMapper;
import hu.bme.aut.timechamp.model.AppUser;
import hu.bme.aut.timechamp.model.Event;
import hu.bme.aut.timechamp.model.Team;
import hu.bme.aut.timechamp.repository.AppUserRepository;
import hu.bme.aut.timechamp.repository.EventRepository;
import hu.bme.aut.timechamp.repository.TeamRepository;
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

    @Autowired
    EventMapper eventMapper;

    @Transactional
    public List<EventDto> findAll(){
        return eventMapper.eventsToDto(eventRepository.findAll());
    }

    @Transactional
    public EventDto createEvent(String name, long teamId, long creatorId) {
        Team team = teamRepository.findById(teamId);
        AppUser creator = appUserRepository.findById(creatorId);

        if(team == null || creator == null) {
            throw new IllegalArgumentException();
        }

        Event event = new Event();
        event.setName(name);
        event.setTeam(team);
        event.setCreator(creator);

        Event savedEvent = eventRepository.save(event);
        team.getEvents().add(savedEvent);
        teamRepository.save(team);
        creator.getEvents().add(savedEvent);
        appUserRepository.save(creator);

        return eventMapper.eventToDto(savedEvent);
    }


    @Transactional
    public EventDto findById(long id) {
        return eventMapper.eventToDto(eventRepository.findById(id));
    }


    @Transactional
    public EventDto addParticipant(long id, long userId) {
        Event event = eventRepository.findById(id);
        AppUser user = appUserRepository.findById(userId);

        if(event == null || user == null) {
            throw new IllegalArgumentException();
        }

        event.getParticipants().add(user);

        Event savedEvent = eventRepository.save(event);
        user.getEvents().add(savedEvent);

        return eventMapper.eventToDto(savedEvent);
    }


    @Transactional
    public EventDto removeParticipant(long id, long userId) {
        Event event = eventRepository.findById(id);
        AppUser user = appUserRepository.findById(userId);

        if(event == null || user == null) {
            throw new IllegalArgumentException();
        }

        event.getParticipants().remove(user);

        Event savedEvent = eventRepository.save(event);
        user.getEvents().remove(savedEvent);

        return eventMapper.eventToDto(savedEvent);
    }


    @Transactional
    public EventDto setTimeById(long id, LocalDateTime time) {
        Event event = eventRepository.findById(id);
        event.setTime(time);
        return eventMapper.eventToDto(eventRepository.save(event));
    }
}
