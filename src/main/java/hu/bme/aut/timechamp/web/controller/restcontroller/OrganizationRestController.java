package hu.bme.aut.timechamp.web.controller.restcontroller;

import hu.bme.aut.timechamp.dto.OrganizationDto;
import hu.bme.aut.timechamp.mapper.OrganizationMapper;
import hu.bme.aut.timechamp.model.Organization;
import hu.bme.aut.timechamp.repository.OrganizationRepository;
import hu.bme.aut.timechamp.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/api/organizations")
public class OrganizationRestController {

    @Autowired
    OrganizationRepository organizationRepository;

    @Autowired
    OrganizationMapper organizationMapper;

    @Autowired
    private OrganizationService organizationService;
    /**
     * Azért transactional mert különben nem tudjuk lekérni a Teams listát a lazy initialization miatt (borosboyo)
     */
    @GetMapping
    @Transactional
    public List<OrganizationDto> findAll(){
        List<Organization> organizations = organizationRepository.findAll();
        return organizationMapper.organizationsToDto(organizations);
    }

    @PostMapping
    public OrganizationDto createOrganization(@RequestParam String name){
        return organizationMapper.organizationToDto(organizationService.createOrganization(name));
    }
}
