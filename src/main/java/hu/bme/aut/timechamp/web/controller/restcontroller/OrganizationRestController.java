package hu.bme.aut.timechamp.web.controller.restcontroller;

import hu.bme.aut.timechamp.dto.OrganizationDto;
import hu.bme.aut.timechamp.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/organizations")
public class OrganizationRestController {

    @Autowired
    private OrganizationService organizationService;

    @GetMapping
    public List<OrganizationDto> findAll(){
        return organizationService.findAll();
    }

    @PutMapping
    public OrganizationDto createOrganization(@RequestParam String name) {
        return RestUtils.executeRestRequest(() -> organizationService.createOrganization(name));
    }

    @GetMapping("/{id}")
    public OrganizationDto findById(@PathVariable long id) {
        return RestUtils.executeRestRequest(() -> organizationService.findById(id), HttpStatus.NOT_FOUND);
    }

    @PostMapping("/{id}/hq")
    public OrganizationDto changeHQ(@PathVariable("id") long id, @RequestParam() long place_id) {
        return RestUtils.executeRestRequest(() -> organizationService.setHQ(id, place_id), HttpStatus.NOT_FOUND);
    }
}
