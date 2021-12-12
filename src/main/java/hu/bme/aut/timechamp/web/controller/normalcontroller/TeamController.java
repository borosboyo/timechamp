package hu.bme.aut.timechamp.web.controller.normalcontroller;

import hu.bme.aut.timechamp.dto.TeamDto;
import hu.bme.aut.timechamp.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Map;

public class TeamController {

    @Autowired
    TeamService teamService;

    @GetMapping("/teams")
    public String home(Map<String, Object> model){
        List<TeamDto> teams = teamService.findAll();

        model.put("teams", teams);
        model.put("newTeam", new TeamDto());
        return "teamPage";
    }

    @PostMapping("/createTeam")
    public String createTeam(TeamDto newTeam){
        teamService.createTeam();
        return "redirect:/teams";
    }
}
