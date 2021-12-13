package hu.bme.aut.timechamp.web.controller.restcontroller;


import hu.bme.aut.timechamp.dto.EventDto;
import hu.bme.aut.timechamp.dto.TeamDto;
import hu.bme.aut.timechamp.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teams")
public class TeamRestController {

    @Autowired
    private TeamService teamService;

    @GetMapping
    public List<TeamDto> findAll(){
        return teamService.findAll();
    }

    @GetMapping("/{id}")
    public TeamDto getTeamById(@PathVariable long id) {
        return RestUtils.executeRestRequest(() -> teamService.findById(id), HttpStatus.NOT_FOUND);
    }

    @PutMapping
    public TeamDto createTeam(@RequestParam String name, @RequestParam long creator_id, @RequestParam long organization_id){
        return RestUtils.executeRestRequest(()->teamService.createTeam(name, creator_id, organization_id));
    }

    @PostMapping("/{id}/join")
    public TeamDto joinTeam(@PathVariable("id") long team_id, @RequestParam long user_id){
        return RestUtils.executeRestRequest(()->teamService.addUser(team_id, user_id));
    }

    @PostMapping("/{id}/rename")
    public TeamDto renameTeam(@PathVariable("id") long team_id, @RequestParam String name){
        return RestUtils.executeRestRequest(()->teamService.renameTeam(team_id, name));
    }

    @PostMapping("/{id}/leave")
    public TeamDto leaveTeam(@PathVariable("id") long team_id, @RequestParam long user_id){
        return RestUtils.executeRestRequest(()->teamService.removeUser(team_id, user_id));
    }

    @PostMapping("/{id}/admin/add")
    public TeamDto addAdmin(@PathVariable("id") long team_id, @RequestParam long user_id){
        return RestUtils.executeRestRequest(()->teamService.addAdminUser(team_id, user_id));
    }

    @PostMapping("/{id}/admin/remove")
    public TeamDto removeAdmin(@PathVariable("id") long team_id, @RequestParam long user_id){
        return RestUtils.executeRestRequest(()->teamService.removeAdminUser(team_id, user_id));
    }
}
