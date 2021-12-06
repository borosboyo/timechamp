package hu.bme.aut.timechamp.mapper;

import hu.bme.aut.timechamp.dto.AppUserDto;
import hu.bme.aut.timechamp.dto.EventDto;
import hu.bme.aut.timechamp.dto.OrganizationDto;
import hu.bme.aut.timechamp.dto.PlaceDto;
import hu.bme.aut.timechamp.dto.TeamDto;
import hu.bme.aut.timechamp.dto.TodoDto;
import hu.bme.aut.timechamp.model.AppUser;
import hu.bme.aut.timechamp.model.Event;
import hu.bme.aut.timechamp.model.Organization;
import hu.bme.aut.timechamp.model.Place;
import hu.bme.aut.timechamp.model.Team;
import hu.bme.aut.timechamp.model.Todo;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-12-06T20:24:46+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.12 (Oracle Corporation)"
)
@Component
public class TodoMapperImpl implements TodoMapper {

    @Override
    public TodoDto todoToDto(Todo todo) {
        if ( todo == null ) {
            return null;
        }

        TodoDto todoDto = new TodoDto();

        todoDto.setId( todo.getId() );
        todoDto.setName( todo.getName() );
        todoDto.setDescription( todo.getDescription() );
        todoDto.setLeaders( appUserListToAppUserDtoList( todo.getLeaders() ) );
        todoDto.setEvent( eventToEventDto( todo.getEvent() ) );

        return todoDto;
    }

    @Override
    public List<TodoDto> todosToDto(List<Todo> todos) {
        if ( todos == null ) {
            return null;
        }

        List<TodoDto> list = new ArrayList<TodoDto>( todos.size() );
        for ( Todo todo : todos ) {
            list.add( todoToDto( todo ) );
        }

        return list;
    }

    protected List<AppUserDto> appUserListToAppUserDtoList(List<AppUser> list) {
        if ( list == null ) {
            return null;
        }

        List<AppUserDto> list1 = new ArrayList<AppUserDto>( list.size() );
        for ( AppUser appUser : list ) {
            list1.add( appUserToAppUserDto( appUser ) );
        }

        return list1;
    }

    protected List<TeamDto> teamListToTeamDtoList(List<Team> list) {
        if ( list == null ) {
            return null;
        }

        List<TeamDto> list1 = new ArrayList<TeamDto>( list.size() );
        for ( Team team : list ) {
            list1.add( teamToTeamDto( team ) );
        }

        return list1;
    }

    protected PlaceDto placeToPlaceDto(Place place) {
        if ( place == null ) {
            return null;
        }

        PlaceDto placeDto = new PlaceDto();

        placeDto.setId( place.getId() );
        placeDto.setName( place.getName() );
        placeDto.setGoogleCode( place.getGoogleCode() );
        placeDto.setLongitude( place.getLongitude() );
        placeDto.setLatitude( place.getLatitude() );
        placeDto.setOrganization( organizationToOrganizationDto( place.getOrganization() ) );

        return placeDto;
    }

    protected OrganizationDto organizationToOrganizationDto(Organization organization) {
        if ( organization == null ) {
            return null;
        }

        OrganizationDto organizationDto = new OrganizationDto();

        organizationDto.setId( organization.getId() );
        organizationDto.setName( organization.getName() );
        organizationDto.setTeams( teamListToTeamDtoList( organization.getTeams() ) );
        organizationDto.setHeadQuarter( placeToPlaceDto( organization.getHeadQuarter() ) );

        return organizationDto;
    }

    protected TeamDto teamToTeamDto(Team team) {
        if ( team == null ) {
            return null;
        }

        TeamDto teamDto = new TeamDto();

        teamDto.setId( team.getId() );
        teamDto.setName( team.getName() );
        teamDto.setAdminAppUsers( appUserListToAppUserDtoList( team.getAdminAppUsers() ) );
        teamDto.setAppUsers( appUserListToAppUserDtoList( team.getAppUsers() ) );
        teamDto.setOrganization( organizationToOrganizationDto( team.getOrganization() ) );

        return teamDto;
    }

    protected EventDto eventToEventDto(Event event) {
        if ( event == null ) {
            return null;
        }

        String name = null;
        LocalDateTime time = null;

        name = event.getName();
        time = event.getTime();

        EventDto eventDto = new EventDto( name, time );

        eventDto.setId( event.getId() );
        eventDto.setTeam( teamToTeamDto( event.getTeam() ) );
        eventDto.setCreator( appUserToAppUserDto( event.getCreator() ) );
        eventDto.setParticipants( appUserListToAppUserDtoList( event.getParticipants() ) );

        return eventDto;
    }

    protected List<EventDto> eventListToEventDtoList(List<Event> list) {
        if ( list == null ) {
            return null;
        }

        List<EventDto> list1 = new ArrayList<EventDto>( list.size() );
        for ( Event event : list ) {
            list1.add( eventToEventDto( event ) );
        }

        return list1;
    }

    protected AppUserDto appUserToAppUserDto(AppUser appUser) {
        if ( appUser == null ) {
            return null;
        }

        AppUserDto appUserDto = new AppUserDto();

        appUserDto.setId( appUser.getId() );
        appUserDto.setEmail( appUser.getEmail() );
        appUserDto.setUserName( appUser.getUserName() );
        appUserDto.setPassword( appUser.getPassword() );
        appUserDto.setEvent( eventListToEventDtoList( appUser.getEvent() ) );
        appUserDto.setTodo( todosToDto( appUser.getTodo() ) );
        appUserDto.setTeam( teamToTeamDto( appUser.getTeam() ) );

        return appUserDto;
    }
}
