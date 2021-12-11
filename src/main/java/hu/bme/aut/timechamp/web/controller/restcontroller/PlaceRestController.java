package hu.bme.aut.timechamp.web.controller.restcontroller;


import hu.bme.aut.timechamp.dto.PlaceDto;
import hu.bme.aut.timechamp.mapper.PlaceMapper;
import hu.bme.aut.timechamp.model.Place;
import hu.bme.aut.timechamp.repository.PlaceRepository;
import hu.bme.aut.timechamp.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/api/places")
public class PlaceRestController {

    @Autowired
    PlaceRepository placeRepository;

    @Autowired
    PlaceMapper placeMapper;

    @Autowired
    private PlaceService placeService;

    @GetMapping
    @Transactional
    public List<PlaceDto> findAll() {
        List<Place> places = placeRepository.findAll();
        return placeMapper.placesToDto(places);
    }

    @PostMapping
    public Place createPlace(@RequestParam String name, @RequestParam String googleCode, @RequestParam double longitude, @RequestParam double latitude){
        return placeService.createPlace(name, googleCode, longitude, latitude);
    }
}
