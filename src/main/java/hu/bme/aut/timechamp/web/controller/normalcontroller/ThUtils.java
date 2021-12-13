package hu.bme.aut.timechamp.web.controller.normalcontroller;

import hu.bme.aut.timechamp.dto.*;
import hu.bme.aut.timechamp.model.AppUser;
import hu.bme.aut.timechamp.model.Todo;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.DateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class ThUtils {
    private ThUtils() {}

    @SuppressWarnings("InstantiationOfUtilityClass")
    private static final ThUtils instance = new ThUtils();

    public static ThUtils getInstance() {
        return instance;
    }

    public static List<Long> listEventIds(List<EventDto> eventDtos){
        return eventDtos.stream().mapToLong(EventDto::getId).boxed().collect(Collectors.toList());
    }

    public static List<String> listTeamNames(List<TeamDto> teamDtos){
        return teamDtos.stream().map(ThUtils::getTeamName).collect(Collectors.toList());
    }

    public static List<Long> listTodoIds(List<TodoDto> todoDtos){
        return todoDtos.stream().mapToLong(TodoDto::getId).boxed().collect(Collectors.toList());
    }

    public static String getTeamName(TeamDto teamDto){
        return teamDto != null ? teamDto.getName() + " (" + teamDto.getId() + ")" : "";
    }

    public static String getPlaceName(PlaceDto placeDto){
        return placeDto != null ? placeDto.getName() + " (" + placeDto.getId() + ")" : "";
    }

    public static String getAppUserName(AppUserDto appUserDto){
        return appUserDto != null ? appUserDto.getUsername() + " (" + appUserDto.getId() + ")" : "";
    }

    public static List<Long> listAppUserIds(List<AppUserDto> appUserDtos) {
        return appUserDtos.stream().mapToLong(AppUserDto::getId).boxed().collect(Collectors.toList());
    }

    public static List<String> listAppUserNames(List<AppUserDto> appUserDtos) {
        return appUserDtos.stream().map(ThUtils::getAppUserName).collect(Collectors.toList());
    }

    public static String getOrganizationName(OrganizationDto organizationDto){
        return organizationDto != null ? organizationDto.getName() + " (" + organizationDto.getId() + ")" : "";
    }

    public static String getEventName(EventDto eventDto){
        return eventDto != null ? eventDto.getName() + " (" + eventDto.getId() + ")" : "";
    }
    public static String getTodoName(TodoDto todoDto){
        return todoDto != null ? todoDto.getName() + " (" + todoDto.getId() + ")" : "";
    }

    public static String getLocalDateTime(LocalDateTime time) {
        if(time == null){
            return "";
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd. HH:mm");

        return time.format(formatter);
    }
}
