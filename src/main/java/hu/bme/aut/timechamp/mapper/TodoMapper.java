package hu.bme.aut.timechamp.mapper;

import hu.bme.aut.timechamp.dto.TeamDto;
import hu.bme.aut.timechamp.model.Team;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TodoMapper {
    public TeamDto teamToDto(Team team);
    public List<TeamDto> teamsToDto(List<Team> teams);
}
