package hu.bme.aut.timechamp.service;

import hu.bme.aut.timechamp.model.Event;
import hu.bme.aut.timechamp.repository.EventRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.time.Month;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureTestDatabase
public class PostponeEventIT {

    @Autowired
    PostponeEventService postponeEventService;

    @Autowired
    EventRepository eventRepository;

    @BeforeEach
    public void init(){
        eventRepository.deleteAll();
    }

    @Test
    public void testPostponeEventByMinute(){
        //ARRANGE
        LocalDateTime time = LocalDateTime.of(2021, Month.NOVEMBER, 17, 21, 30);
        Event event = new Event("sampleevent",time);
        eventRepository.save(event);

        //ACT
        postponeEventService.postponeByMinute("sampleevent",30);

        //ASSERT
        Event eventFromDb = eventRepository.findById(event.getId());
        assertEquals(LocalDateTime.of(2021, Month.NOVEMBER, 17, 22, 0),eventFromDb.getTime());

    }

    @Test
    public void testPostponeEventByHour(){
        //ARRANGE
        LocalDateTime time = LocalDateTime.of(2021, Month.NOVEMBER, 17, 21, 30);
        Event event = new Event("sampleevent",time);
        eventRepository.save(event);

        //ACT
        postponeEventService.postponeByHour("sampleevent",1);

        //ASSERT
        Event eventFromDb = eventRepository.findById(event.getId());
        assertEquals(LocalDateTime.of(2021, Month.NOVEMBER, 17, 22, 30),eventFromDb.getTime());

    }

    @Test
    public void testPostponeEventByDay(){
        //ARRANGE
        LocalDateTime time = LocalDateTime.of(2021, Month.NOVEMBER, 17, 21, 30);
        Event event = new Event("sampleevent",time);
        eventRepository.save(event);

        //ACT
        postponeEventService.postponeByDay("sampleevent",1);

        //ASSERT
        Event eventFromDb = eventRepository.findById(event.getId());
        assertEquals(LocalDateTime.of(2021, Month.NOVEMBER, 18, 21, 30),eventFromDb.getTime());

    }
}
