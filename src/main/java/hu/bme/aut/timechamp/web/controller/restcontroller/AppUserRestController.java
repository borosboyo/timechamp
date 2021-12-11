package hu.bme.aut.timechamp.web.controller.restcontroller;


import hu.bme.aut.timechamp.dto.AppUserDto;
import hu.bme.aut.timechamp.mapper.AppUserMapper;
import hu.bme.aut.timechamp.model.AppUser;
import hu.bme.aut.timechamp.repository.AppUserRepository;
import hu.bme.aut.timechamp.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
@RequestMapping("/api/appusers")
public class AppUserRestController {
    @Autowired
    AppUserService appUserService;

    @GetMapping
    public List<AppUserDto> findAll(){
        return appUserService.findAll();
    }
    @PostMapping
    public AppUserDto createAppUser(@RequestParam String email, @RequestParam String username, @RequestParam String password){
        long id = appUserService.createUser(email, username, password);
        return appUserService.findById(id);
    }

    @GetMapping("/{id}")
    public AppUserDto findById(@PathVariable long id){
        return appUserService.findById(id);
    }

    @PostMapping("/{id}")
    public void updateAppUserDetails(@PathVariable long id, @RequestBody AppUserDto appUserDto){
        appUserService.updateById(id, appUserDto.getEmail(), appUserDto.getUsername(), appUserDto.getPassword());
    }
}
