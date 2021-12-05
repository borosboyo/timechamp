package hu.bme.aut.timechamp.controller.restcontroller;

import hu.bme.aut.timechamp.model.Organization;
import hu.bme.aut.timechamp.model.Place;
import hu.bme.aut.timechamp.model.Team;
import hu.bme.aut.timechamp.repository.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/api/organizations")
public class OrganizationRestController {

    @Autowired
    OrganizationRepository organizationRepository;

    /**
     * Azért transactional mert különben nem tudjuk lekérni a Teams listát a lazy initialization miatt (borosboyo)
     */
    @GetMapping
    @Transactional
    public List<Organization> findAll(){
        List<Organization> organizations = organizationRepository.findAll();
        organizations.forEach(this::setUnneededFieldsToNull);
        return organizations;
    }

    private void setUnneededFieldsToNull(Organization organization){
        List<Team> teams = organization.getTeams();
        if(teams != null){
            for(Team t : teams)
                t.setOrganization(null);
        }
        Place p = organization.getHeadQuarters();
        if(p != null){
            p.setOrganization(null);
        }
    }

    @PostMapping
    public Organization createOrganization(@RequestBody Organization organization){
        return organizationRepository.save(organization);
    }
}
