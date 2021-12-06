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
    date = "2021-12-06T19:41:43+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.12 (Oracle Corporation)"
)
@Component
public class AppUserMapperImpl implements AppUserMapper {

    @Override
    public AppUserDto appUserToDto(AppUser appUser) {
        if ( appUser == null ) {
            return null;
        }

        AppUserDto appUserDto = new AppUserDto();

        appUserDto.setId( appUser.getId() );
        appUserDto.setEmail( appUser.getEmail() );
        appUserDto.setUserName( appUser.getUserName() );
        appUserDto.setPassword( appUser.getPassword() );
        appUserDto.setEvent( eventListToEventDtoList( appUser.getEvent() ) );
        appUserDto.setTodo( todoListToTodoDtoList( appUser.getTodo() ) );
        appUserDto.setTeam( teamToTeamDto( appUser.getTeam() ) );

        return appUserDto;
    }

    @Override
    public List<AppUserDto> appUsersToDto(List<AppUser> appUsers) {
        if ( appUsers == null ) {
            return null;
        }

        List<AppUserDto> list = new ArrayList<AppUserDto>( appUsers.size() );
        for ( AppUser appUser : appUsers ) {
            list.add( appUserToDto( appUser ) );
        }

        return list;
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
        teamDto.setAdminAppUsers( appUsersToDto( team.getAdminAppUsers() ) );
        teamDto.setAppUsers( appUsersToDto( team.getAppUsers() ) );
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
        eventDto.setCreator( appUserToDto( event.getCreator() ) );
        eventDto.setParticipants( appUsersToDto( event.getParticipants() ) );

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

    protected TodoDto todoToTodoDto(Todo todo) {
        if ( todo == null ) {
            return null;
        }

        TodoDto todoDto = new TodoDto();

        todoDto.setId( todo.getId() );
        todoDto.setName( todo.getName() );
        todoDto.setDescription( todo.getDescription() );
        todoDto.setLeaders( appUsersToDto( todo.getLeaders() ) );
        todoDto.setEvent( eventToEventDto( todo.getEvent() ) );

        return todoDto;
    }

    protected List<TodoDto> todoListToTodoDtoList(List<Todo> list) {
        if ( list == null ) {
            return null;
        }

        List<TodoDto> list1 = new ArrayList<TodoDto>( list.size() );
        for ( Todo todo : list ) {
            list1.add( todoToTodoDto( todo ) );
        }

        return list1;
    }
}
