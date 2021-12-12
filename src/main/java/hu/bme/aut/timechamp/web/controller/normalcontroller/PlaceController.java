package hu.bme.aut.timechamp.web.controller.normalcontroller;


import hu.bme.aut.timechamp.dto.PlaceDto;
import hu.bme.aut.timechamp.model.Place;
import hu.bme.aut.timechamp.repository.PlaceRepository;
import hu.bme.aut.timechamp.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;

@Controller
public class PlaceController {

    @Autowired
    PlaceService placeService;

    @GetMapping("/places")
    public String home(Map<String, Object> model){
        List<PlaceDto> places = placeService.findAll();

        model.put("places", places);
        model.put("newPlace", new PlaceDto());
        return "placePage";
    }

    @PostMapping("/createPlace")
    public String createPlace(PlaceDto newPlace){
        placeService.createPlace(newPlace.getName(), newPlace.getGoogleCode(), newPlace.getLongitude(), newPlace.getLatitude());
        return "redirect:/places";
    }

}
