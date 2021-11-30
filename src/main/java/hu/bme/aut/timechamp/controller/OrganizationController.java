package hu.bme.aut.timechamp.controller;

import hu.bme.aut.timechamp.model.Organization;
import hu.bme.aut.timechamp.repository.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Map;

@Controller
public class OrganizationController {

    @Autowired
    OrganizationRepository organizationRepository;

    @GetMapping("/")
    public String home(Map<String, Object> model){
        List<Organization> organizations = organizationRepository.findAll();
        model.put("organizations", organizations);
        model.put("organization", new Organization());
        return "organizationPage";
    }

    @PostMapping("/createOrganization")
    public String createOrganization(Organization organization){
        organizationRepository.save(organization);
        return "redirect:/";
    }
}
