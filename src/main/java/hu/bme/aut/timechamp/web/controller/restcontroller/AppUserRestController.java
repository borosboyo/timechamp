package hu.bme.aut.timechamp.web.controller.restcontroller;

import hu.bme.aut.timechamp.dto.AppUserDto;
import hu.bme.aut.timechamp.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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
        return RestUtils.executeRestRequest(()->appUserService.createUser(email, username, password));
    }

    @GetMapping("/{id}")
    public AppUserDto findById(@PathVariable long id){
        return RestUtils.executeRestRequest(()->appUserService.findById(id), HttpStatus.NOT_FOUND);
    }

    @PostMapping("/{id}")
    public AppUserDto updateAppUserDetails(@PathVariable long id, @RequestBody AppUserDto appUserDto){
        if(appUserService.updateById(id, appUserDto.getEmail(), appUserDto.getUsername(), appUserDto.getPassword())){
            return appUserService.findById(id);
        }
        throw new ResponseStatusException(HttpStatus.NOT_MODIFIED);
    }
}
