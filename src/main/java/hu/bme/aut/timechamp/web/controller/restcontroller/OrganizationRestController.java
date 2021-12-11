package hu.bme.aut.timechamp.web.controller.restcontroller;

import hu.bme.aut.timechamp.dto.OrganizationDto;
import hu.bme.aut.timechamp.mapper.OrganizationMapper;
import hu.bme.aut.timechamp.model.Organization;
import hu.bme.aut.timechamp.repository.OrganizationRepository;
import hu.bme.aut.timechamp.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/organizations")
public class OrganizationRestController {

    @Autowired
    OrganizationMapper organizationMapper;

    @Autowired
    private OrganizationService organizationService;

    @GetMapping
    public List<OrganizationDto> findAll(){
        return organizationMapper.organizationsToDto(organizationService.findAll());
    }

    @PostMapping
    public OrganizationDto createOrganization(@RequestParam String name){
        return organizationMapper.organizationToDto(organizationService.createOrganization(name));
    }
}
