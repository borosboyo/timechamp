package hu.bme.aut.timechamp.web.controller.restcontroller;


import hu.bme.aut.timechamp.dto.AppUserDto;
import hu.bme.aut.timechamp.dto.OrganizationDto;
import hu.bme.aut.timechamp.dto.PlaceDto;
import hu.bme.aut.timechamp.mapper.PlaceMapper;
import hu.bme.aut.timechamp.model.Place;
import hu.bme.aut.timechamp.repository.PlaceRepository;
import hu.bme.aut.timechamp.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/places")
public class PlaceRestController {

    @Autowired
    private PlaceService placeService;

    @GetMapping
    public List<PlaceDto> findAll() {
        return placeService.findAll();
    }

    @PostMapping
    public PlaceDto createPlace(@RequestParam String name, @RequestParam String googleCode, @RequestParam double longitude, @RequestParam double latitude){
        return RestUtils.executeRestRequest(()->placeService.createPlace(name, googleCode, longitude, latitude));
    }

    @GetMapping("/{id}")
    public PlaceDto findById(@PathVariable long id){
        return RestUtils.executeRestRequest(()->placeService.findById(id), HttpStatus.NOT_FOUND);
    }
}
