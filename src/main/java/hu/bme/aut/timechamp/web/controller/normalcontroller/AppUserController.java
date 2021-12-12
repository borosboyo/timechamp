package hu.bme.aut.timechamp.web.controller.normalcontroller;

import hu.bme.aut.timechamp.dto.AppUserDto;
import hu.bme.aut.timechamp.service.AppUserService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Map;

@Controller
public class AppUserController {

    @Autowired
    AppUserService appUserService;

    @GetMapping("/appUsers")
    public String home(Map<String, Object> model){
        List<AppUserDto> appUsers = appUserService.findAll();

        model.put("appUsers", appUsers);
        model.put("newAppUser", new AppUserDto());
        return "appUserPage";
    }

    @PostMapping("/createAppUser")
    public String createAppUser(AppUserParameters appUserParameters){
        appUserService.createUser(appUserParameters.getEmail(),appUserParameters.getUsername(),appUserParameters.getPassword());
        return "redirect:/appUsers";
    }

    @Setter
    @Getter
    static
    class AppUserParameters {
        private String email;
        private String username;
        private String password;
    }
}
