package hu.bme.aut.timechamp.web.controller.normalcontroller;


import hu.bme.aut.timechamp.model.Place;
import hu.bme.aut.timechamp.repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Map;

@Controller
public class PlaceController {

    @Autowired
    PlaceRepository placeRepository;

    @GetMapping("/places")
    public String home(Map<String, Object> model){
        List<Place> places = placeRepository.findAll();

        model.put("places", places);
        model.put("place", new Place());

        return "placePage";
    }

    @PostMapping("/createPlace")
    public String createPlace(Place place){
        placeRepository.save(place);
        return "redirect:/places";
    }

}
