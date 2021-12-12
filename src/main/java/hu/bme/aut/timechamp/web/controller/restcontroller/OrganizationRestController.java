package hu.bme.aut.timechamp.web.controller.restcontroller;

import hu.bme.aut.timechamp.dto.AppUserDto;
import hu.bme.aut.timechamp.dto.OrganizationDto;
import hu.bme.aut.timechamp.mapper.OrganizationMapper;
import hu.bme.aut.timechamp.model.Organization;
import hu.bme.aut.timechamp.repository.OrganizationRepository;
import hu.bme.aut.timechamp.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
    public OrganizationDto createOrganization(@RequestParam String name, RedirectAttributes redirectAttributes){
        try {
            OrganizationDto result = organizationService.createOrganization(name);
            if(result == null){
                throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
            }
            return result;
        }
        catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Organization by this name already exists");
        }
    }

    @GetMapping("/{id}")
    public OrganizationDto findById(@PathVariable long id){
        OrganizationDto result = organizationService.findById(id);
        if(result == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return result;
    }

    @PostMapping("/{id}/hq")
    public OrganizationDto changeHQ(@PathVariable("id") long id, @RequestParam() long place_id, RedirectAttributes redirectAttributes){
        organizationService.setHQ(id, place_id);
        return organizationService.findById(id);
    }
}
