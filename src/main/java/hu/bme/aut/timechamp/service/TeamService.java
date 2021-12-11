package hu.bme.aut.timechamp.service;

import hu.bme.aut.timechamp.dto.TeamDto;
import hu.bme.aut.timechamp.mapper.TeamMapper;
import hu.bme.aut.timechamp.model.AppUser;
import hu.bme.aut.timechamp.model.Organization;
import hu.bme.aut.timechamp.model.Team;
import hu.bme.aut.timechamp.repository.AppUserRepository;
import hu.bme.aut.timechamp.repository.OrganizationRepository;
import hu.bme.aut.timechamp.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TeamService {

    @Autowired
    TeamRepository teamRepository;

    @Autowired
    TeamMapper teamMapper;

    @Autowired
    AppUserRepository appUserRepository;

    @Autowired
    OrganizationRepository organizationRepository;


    @Transactional
    public List<TeamDto> findAll() {
        return teamMapper.teamsToDto(teamRepository.findAll());
    }


    @Transactional
    public TeamDto getById(long id) {
        return teamMapper.teamToDto(teamRepository.findById(id));
    }


    @Transactional
    public TeamDto createTeam(String name, long creatorId, long organizationId) {
        AppUser adminUser = appUserRepository.findById(creatorId);
        Organization organization = organizationRepository.findById(organizationId);

        if(adminUser == null || organization == null) {
            throw new IllegalArgumentException();
        }

        Team team = new Team();
        team.setName(name);
        team.setOrganization(organization);
        team.getAdminAppUsers().add(adminUser);

        Team savedTeam = teamRepository.save(team);

        organization.getTeams().add(team);
        organizationRepository.save(organization);

        adminUser.setTeam(savedTeam);
        appUserRepository.save(adminUser);

        return teamMapper.teamToDto(savedTeam);
    }

    @Transactional
    public TeamDto addAdminUser(long id, long adminId) {
        Team team = teamRepository.findById(id);
        AppUser admin = appUserRepository.findById(adminId);

        if(team == null || admin == null) {
            throw new IllegalArgumentException();
        }

        team.getAdminAppUsers().add(admin);
        Team savedTeam = teamRepository.save(team);
        admin.setTeam(savedTeam);
        appUserRepository.save(admin);

        return teamMapper.teamToDto(savedTeam);
    }

    @Transactional
    public TeamDto addUser(long id, long userId) {
        Team team = teamRepository.findById(id);
        AppUser user = appUserRepository.findById(userId);

        if(team == null || user == null) {
            throw new IllegalArgumentException();
        }

        team.getAppUsers().add(user);
        Team savedTeam = teamRepository.save(team);
        user.setTeam(savedTeam);
        appUserRepository.save(user);

        return teamMapper.teamToDto(savedTeam);
    }
}
