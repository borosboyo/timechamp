package hu.bme.aut.timechamp.web.controller.restcontroller;


import hu.bme.aut.timechamp.dto.PlaceDto;
import hu.bme.aut.timechamp.mapper.PlaceMapper;
import hu.bme.aut.timechamp.model.Place;
import hu.bme.aut.timechamp.repository.PlaceRepository;
import hu.bme.aut.timechamp.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/places")
public class PlaceRestController {

    @Autowired
    PlaceMapper placeMapper;

    @Autowired
    private PlaceService placeService;

    @GetMapping
    public List<PlaceDto> findAll() {
        return placeMapper.placesToDto(placeService.findAll());
    }

    @PostMapping
    public Place createPlace(@RequestParam String name, @RequestParam String googleCode, @RequestParam double longitude, @RequestParam double latitude){
        return placeService.createPlace(name, googleCode, longitude, latitude);
    }
}
