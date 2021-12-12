package hu.bme.aut.timechamp.web.controller.normalcontroller;

import hu.bme.aut.timechamp.dto.TeamDto;
import hu.bme.aut.timechamp.service.TeamService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Map;

@Controller
public class TeamController {

    @Autowired
    TeamService teamService;

    @GetMapping("/teams")
    public String home(Map<String, Object> model){
        List<TeamDto> teams = teamService.findAll();

        model.put("teams", teams);
        model.put("newTeam", new TeamParameters());
        return "teamPage";
    }

    @PostMapping("/createTeam")
    public String createTeam(TeamParameters teamParameters){
        teamService.createTeam(teamParameters.getName(),teamParameters.getCreatorId(),teamParameters.getOrganizationId());
        return "redirect:/teams";
    }

    @Setter
    @Getter
    static
    class TeamParameters {
        private String name;
        private long creatorId;
        private long organizationId;
    }
}
