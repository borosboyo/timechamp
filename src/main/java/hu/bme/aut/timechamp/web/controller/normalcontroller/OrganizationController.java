package hu.bme.aut.timechamp.web.controller.normalcontroller;

import hu.bme.aut.timechamp.dto.OrganizationDto;
import hu.bme.aut.timechamp.service.OrganizationService;
import lombok.Getter;
import lombok.Setter;
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
        model.put("newOrganization", new OrganizationParameters());
        model.put("ThUtils", ThUtils.getInstance());
        return "organizationPage";
    }

    @PostMapping("/createOrganization")
    public String createOrganization(OrganizationParameters organizationParameters){
        organizationService.createOrganization(organizationParameters.getName());
        return "redirect:/organizations";
    }

    @Setter
    @Getter
    static
    class OrganizationParameters {
        private String name;
        private long hqId;
    }
}
