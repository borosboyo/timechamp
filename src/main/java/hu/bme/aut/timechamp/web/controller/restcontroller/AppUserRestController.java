package hu.bme.aut.timechamp.web.controller.restcontroller;


import hu.bme.aut.timechamp.dto.AppUserDto;
import hu.bme.aut.timechamp.mapper.AppUserMapper;
import hu.bme.aut.timechamp.model.AppUser;
import hu.bme.aut.timechamp.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/appusers")
public class AppUserRestController {

    @Autowired
    AppUserRepository appUserRepository;

    @Autowired
    AppUserMapper appUserMapper;

    @GetMapping
    public List<AppUserDto> findAll(){
        List<AppUser> appUsers = appUserRepository.findAll();
        return appUserMapper.appUsersToDto(appUsers);
    }

}
