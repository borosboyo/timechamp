package hu.bme.aut.timechamp.service;

import hu.bme.aut.timechamp.model.Event;
import hu.bme.aut.timechamp.repository.EventRepository;
import net.bytebuddy.asm.Advice;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class PostponeEventTest {

    @InjectMocks
    PostponeEventService postponeEventService;

    @Mock
    EventRepository eventRepository;

    @Test
    public void testPostponeEventByMinute(){
        //ARRANGE
        LocalDateTime time = LocalDateTime.of(2021, Month.NOVEMBER, 17, 21, 30);
        Event event = new Event("sampleevent",time);
        when(eventRepository.findByName("sampleevent")).thenReturn(Arrays.asList(event));

        //ACT
        postponeEventService.postponeByMinute("sampleevent",30);

        //ASSERT
        Assertions.assertEquals(LocalDateTime.of(2021, Month.NOVEMBER, 17, 22, 0),event.getTime());

    }

    @Test
    public void testPostponeEventByHour(){
        //ARRANGE
        LocalDateTime time = LocalDateTime.of(2021, Month.NOVEMBER, 17, 21, 30);
        Event event = new Event("sampleevent",time);
        when(eventRepository.findByName("sampleevent")).thenReturn(Arrays.asList(event));

        //ACT
        postponeEventService.postponeByHour("sampleevent",1);

        //ASSERT
        Assertions.assertEquals(LocalDateTime.of(2021, Month.NOVEMBER, 17, 22, 30),event.getTime());
    }

    @Test
    public void testPostponeEventByDay(){
        //ARRANGE
        LocalDateTime time = LocalDateTime.of(2021, Month.NOVEMBER, 17, 21, 30);
        Event event = new Event("sampleevent",time);
        when(eventRepository.findByName("sampleevent")).thenReturn(Arrays.asList(event));

        //ACT
        postponeEventService.postponeByDay("sampleevent",1);

        //ASSERT
        Assertions.assertEquals(LocalDateTime.of(2021, Month.NOVEMBER, 18, 21, 30),event.getTime());
    }
}
