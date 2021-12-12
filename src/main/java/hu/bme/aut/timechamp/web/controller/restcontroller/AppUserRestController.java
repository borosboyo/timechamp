package hu.bme.aut.timechamp.web.controller.restcontroller;


import hu.bme.aut.timechamp.dto.AppUserDto;
import hu.bme.aut.timechamp.mapper.AppUserMapper;
import hu.bme.aut.timechamp.model.AppUser;
import hu.bme.aut.timechamp.repository.AppUserRepository;
import hu.bme.aut.timechamp.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
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

    @PutMapping
    public AppUserDto createAppUser(@RequestParam String email, @RequestParam String username, @RequestParam String password){
        AppUserDto result;
        try {
            result = appUserService.createUser(email, username, password);
        } catch (IllegalArgumentException exception){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        if(result == null){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return result;
    }

    @GetMapping("/{id}")
    public AppUserDto findById(@PathVariable long id){
        AppUserDto result = appUserService.findById(id);
        if(result == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return result;
    }

    @PostMapping("/{id}")
    public AppUserDto updateAppUserDetails(@PathVariable long id, @RequestBody AppUserDto appUserDto){
        if(appUserService.updateById(id, appUserDto.getEmail(), appUserDto.getUsername(), appUserDto.getPassword())){
            return appUserService.findById(id);
        }
        throw new ResponseStatusException(HttpStatus.NOT_MODIFIED);
    }
}
