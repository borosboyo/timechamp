package hu.bme.aut.timechamp.web.controller.normalcontroller;

import hu.bme.aut.timechamp.dto.OrganizationDto;
import hu.bme.aut.timechamp.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Map;

@Controller
public class OrganizationController {
    
    @Autowired
    OrganizationService organizationService;

    @GetMapping("/organizations")
    public String home(Map<String, Object> model){
        List<OrganizationDto> organizations = organizationService.findAll();

        model.put("organizations", organizations);
        model.put("newOrganization", new OrganizationDto());
        return "organizationPage";
    }

    @PostMapping("/createOrganization")
    public String createOrganization(OrganizationDto newOrganization){
        organizationService.createOrganization();
        return "redirect:/organizations";
    }
}
