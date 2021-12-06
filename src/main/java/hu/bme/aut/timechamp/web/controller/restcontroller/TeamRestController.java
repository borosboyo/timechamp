package hu.bme.aut.timechamp.web.controller.restcontroller;


import hu.bme.aut.timechamp.dto.TeamDto;
import hu.bme.aut.timechamp.mapper.TeamMapper;
import hu.bme.aut.timechamp.model.Team;
import hu.bme.aut.timechamp.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/teams")
public class TeamRestController {

    @Autowired
    TeamRepository teamRepository;

    @Autowired
    TeamMapper teamMapper;

    @GetMapping
    public List<TeamDto> findAll(){
        List<Team> teams = teamRepository.findAllWithOrganizationTeams();
        return teamMapper.teamsToDto(teams);
    }
}
