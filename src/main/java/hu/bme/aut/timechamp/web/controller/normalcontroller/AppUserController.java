package hu.bme.aut.timechamp.web.controller.normalcontroller;

import hu.bme.aut.timechamp.dto.AppUserDto;
import hu.bme.aut.timechamp.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Map;

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
    public String createAppUser(AppUserDto newAppUser){
        appUserService.createUser();
        return "redirect:/appUsers";
    }
}
