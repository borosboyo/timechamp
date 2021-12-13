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
        model.put("renameTeam", new TeamParameters());
        model.put("joinTeam", new TeamUserParameters());
        model.put("leaveTeam", new TeamUserParameters());
        model.put("addAdmin", new TeamUserParameters());
        model.put("removeAdmin", new TeamUserParameters());
        model.put("thUtils", ThUtils.getInstance());
        return "teamPage";
    }

    @PostMapping("/createTeam")
    public String createTeam(TeamParameters teamParameters){
        teamService.createTeam(teamParameters.getName(),teamParameters.getCreatorId(),teamParameters.getOrganizationId());
        return "redirect:/teams";
    }

    @PostMapping("/joinTeam")
    public String joinTeam(TeamUserParameters teamUserParameters){
        teamService.addUser(teamUserParameters.getTeamId(), teamUserParameters.getUserId());
        return "redirect:/teams";
    }
    @PostMapping("/leaveTeam")
    public String leaveTeam(TeamUserParameters teamUserParameters){
        teamService.removeUser(teamUserParameters.getTeamId(), teamUserParameters.getUserId());
        return "redirect:/teams";
    }

    @PostMapping("/addTeamAdmin")
    public String addAdmin(TeamUserParameters teamUserParameters){
        teamService.addAdminUser(teamUserParameters.getTeamId(), teamUserParameters.getUserId());
        return "redirect:/teams";
    }
    @PostMapping("/removeTeamAdmin")
    public String removeAdmin(TeamUserParameters teamUserParameters){
        teamService.removeAdminUser(teamUserParameters.getTeamId(), teamUserParameters.getUserId());
        return "redirect:/teams";
    }

    @PostMapping("/renameTeam")
    public String renameTeam(TeamParameters teamParameters){
        teamService.renameTeam(teamParameters.getId(), teamParameters.getName());
        return "redirect:/teams";
    }

    @Setter
    @Getter
    static
    class TeamParameters {
        private long id;
        private String name;
        private long creatorId;
        private long organizationId;
    }

    @Setter
    @Getter
    static
    class TeamUserParameters {
        private long teamId;
        private long userId;
    }
}
