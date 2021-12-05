package hu.bme.aut.timechamp.controller.restcontroller;


import hu.bme.aut.timechamp.model.Organization;
import hu.bme.aut.timechamp.model.Place;
import hu.bme.aut.timechamp.repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/places")
public class PlaceRestController {

    @Autowired
    PlaceRepository placeRepository;

    @GetMapping
    public List<Place> findAll(){
        List<Place> places = placeRepository.findAll();

        places.forEach(this::setUnnededPlaceFieldsToNull);
        return placeRepository.findAll();
    }

    private void setUnnededPlaceFieldsToNull(Place place){
        Organization org = place.getOrganization();
        if(org != null){
            org.setHeadQuarters(null);
        }
    }
    @PostMapping
    public Place createPlace(@RequestBody Place place){
        return placeRepository.save(place);
    }
}
